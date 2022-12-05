package domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public record LottoRecord(
        @Min(1)
        @Max(45)
        int number
) {
    public LottoRecord {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("로또 번호는 1~45 사이의 숫자여야 합니다.");
        }
    }

    public static LottoRecord of(int number) {
        return new LottoRecord(number);
    }
}

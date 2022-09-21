package domain;

import static lombok.AccessLevel.PRIVATE;

import lombok.Builder;
import lombok.ToString;

@ToString
public class LottoNumber implements Comparable<LottoNumber> {

    private final int number;

    @Builder(access = PRIVATE)
    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(int number) {
        validateNumber(number);
        return new LottoNumber(number);
    }

    private static void validateNumber(int number) {
        if (number >= 1 && number <= 45) {
            return;
        }
        throw new IllegalArgumentException("로또 번호는 1~45 사이의 숫자만 가능합니다.");
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(number, o.number);
    }
}

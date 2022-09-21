package domain;

import lombok.Builder;
import lombok.ToString;

@ToString
public class LottoNumber {

    private final int number;

    @Builder(access = lombok.AccessLevel.PRIVATE)
    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(int number) {
        return new LottoNumber(number);
    }

}

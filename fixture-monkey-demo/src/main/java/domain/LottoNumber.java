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
        return new LottoNumber(number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(number, o.number);
    }
}

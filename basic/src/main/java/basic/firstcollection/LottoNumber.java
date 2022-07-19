package basic.firstcollection;

import lombok.Value;

@Value
public class LottoNumber {
    int value;

    public static LottoNumber create(int value) {
        return new LottoNumber(value);
    }
}

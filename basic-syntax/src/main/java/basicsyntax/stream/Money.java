package basicsyntax.stream;

import java.math.BigDecimal;
import lombok.Value;

@Value
public class Money implements Comparable<Money> {
    BigDecimal amount;

    public static Money wons(int amount) {
        return new Money(BigDecimal.valueOf(amount));
    }

    // FIXME 2022/06/18: compareTo 구현
    @Override
    public int compareTo(Money o) {
        return 0;
    }
}

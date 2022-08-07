package basic.assertion;

import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.util.Assert;

@RequiredArgsConstructor
public class Money {

    public static final Money ZERO = new Money(BigDecimal.ZERO);
    private final BigDecimal amount;

    public static Money of(long amount) {
        Assert.isTrue(isPositive(amount), "amount must be positive.");
        return new Money(BigDecimal.valueOf(amount));
    }

    private static boolean isPositive(long amount) {
        return amount > 0;
    }

    private static boolean isNegative(long amount) {
        return amount < 0;
    }
}

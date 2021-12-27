package com.example.test.cleanarchitecture.account.domain;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value
public class Money {

    Money ZERO = Money.wons(0);

    BigDecimal amount;

    private static Money wons(long amount) {
        return new Money(BigDecimal.valueOf(amount));
    }

    public static Money add(Money money, Money calculateBalance) {
        return new Money(money.amount.add(calculateBalance.amount));
    }

    public boolean isPositive() {
        return this.amount.compareTo(BigDecimal.ZERO) > 0;
    }

    public Money negate() {
        return new Money(amount.negate());
    }

}

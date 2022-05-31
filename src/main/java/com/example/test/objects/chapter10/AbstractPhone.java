package com.example.test.objects.chapter10;

import com.example.test.objects.chapter01.movie.domain.Money;
import java.time.Duration;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractPhone {
    protected final Money amount;
    protected final Duration seconds;
    protected final List<Call> calls;

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            result = result.plus(amount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
        }

        return result;
    }

}

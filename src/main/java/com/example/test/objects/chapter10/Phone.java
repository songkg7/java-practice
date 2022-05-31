package com.example.test.objects.chapter10;

import com.example.test.objects.chapter01.movie.domain.Money;
import java.time.Duration;
import java.util.List;

public class Phone extends AbstractPhone {

    public Phone(Money amount, Duration seconds, List<Call> calls) {
        super(amount, seconds, calls);
    }

    public void call(Call call) {
        calls.add(call);
    }

    public List<Call> getCalls() {
        return calls;
    }

    public Money getAmount() {
        return amount;
    }

    public Duration getSeconds() {
        return seconds;
    }

}

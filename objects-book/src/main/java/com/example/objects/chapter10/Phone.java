package com.example.objects.chapter10;

import com.example.objects.chapter01.movie.domain.Money;
import java.time.Duration;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Phone {
    private final Money amount;
    private final Duration seconds;
    private final List<Call> calls;

    private final RatePolicy ratePolicy;

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

    public Money calculateFee() {
        return ratePolicy.calculateFee(this);
    }
}

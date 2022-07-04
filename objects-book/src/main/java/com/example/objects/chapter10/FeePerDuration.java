package com.example.objects.chapter10;

import com.example.objects.chapter01.movie.domain.Money;
import com.example.objects.chapter10.domain.DateTimeInterval;
import java.time.Duration;

public class FeePerDuration {
    private Money fee;
    private Duration duration;

    public FeePerDuration(Money fee, Duration duration) {
        this.fee = fee;
        this.duration = duration;
    }

    public Money calculate(DateTimeInterval interval) {
        return fee.times(Math.ceil((double) interval.duration().toNanos() / duration.toNanos()));
    }
}

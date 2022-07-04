package com.example.objects.chapter10;

import com.example.objects.chapter01.movie.domain.Money;
import com.example.objects.chapter10.domain.Call;

public class FeeRule {
    private FeeCondition feeCondition;
    private FeePerDuration feePerDuration;

    public FeeRule(FeeCondition feeCondition, FeePerDuration feePerDuration) {
        this.feeCondition = feeCondition;
        this.feePerDuration = feePerDuration;
    }

    public Money calculateFee(Call call) {
        return feeCondition.findTimeIntervals(call)
                .stream()
                .map(interval -> feePerDuration.calculate(interval))
                .reduce(Money.ZERO, Money::plus);
    }
}

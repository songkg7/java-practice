package com.example.objects.chapter10;

import com.example.objects.chapter01.movie.domain.Money;

public class RateDiscountablePolicy extends AdditionalRatePolicy {

    private Money discountFee;

    public RateDiscountablePolicy(Money discountFee, RatePolicy next) {
        super(next);
        this.discountFee = discountFee;
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return fee.minus(discountFee);
    }
}

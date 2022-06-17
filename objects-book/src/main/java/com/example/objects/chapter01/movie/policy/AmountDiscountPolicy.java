package com.example.objects.chapter01.movie.policy;

import com.example.objects.chapter01.movie.condition.DiscountCondition;
import com.example.objects.chapter01.movie.domain.Money;
import com.example.objects.chapter01.movie.domain.Screening;
import lombok.ToString;

@ToString
public class AmountDiscountPolicy extends DiscountPolicy {

    private Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }

}

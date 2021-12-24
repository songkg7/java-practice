package com.example.test.objects.chapter01.movie.policy;

import com.example.test.objects.chapter01.movie.condition.DiscountCondition;
import com.example.test.objects.chapter01.movie.domain.Money;
import com.example.test.objects.chapter01.movie.domain.Screening;
import lombok.ToString;

@ToString
public class AmountDiscountPolicy extends DefaultDiscountPolicy {

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

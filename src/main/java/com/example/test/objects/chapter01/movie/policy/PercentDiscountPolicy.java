package com.example.test.objects.chapter01.movie.policy;

import com.example.test.objects.chapter01.movie.condition.DiscountCondition;
import com.example.test.objects.chapter01.movie.domain.Money;
import com.example.test.objects.chapter01.movie.domain.Screening;
import lombok.ToString;

@ToString
public class PercentDiscountPolicy extends DefaultDiscountPolicy {

    private double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }

}

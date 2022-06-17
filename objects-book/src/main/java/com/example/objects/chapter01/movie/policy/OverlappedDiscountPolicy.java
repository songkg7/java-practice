package com.example.objects.chapter01.movie.policy;

import com.example.objects.chapter01.movie.condition.DiscountCondition;
import com.example.objects.chapter01.movie.domain.Money;
import com.example.objects.chapter01.movie.domain.Screening;
import java.util.List;

public class OverlappedDiscountPolicy extends DiscountPolicy {

    private final List<DiscountPolicy> discountPolicies;

    public OverlappedDiscountPolicy(List<DiscountPolicy> discountPolicies, DiscountCondition... conditions) {
        super(conditions);
        this.discountPolicies = discountPolicies;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        Money result = Money.ZERO;
        for (DiscountPolicy each : discountPolicies) {
            result = result.plus(each.getDiscountAmount(screening));
        }
        return result;
    }
}

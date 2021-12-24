package com.example.test.objects.chapter01.movie.policy;

import com.example.test.objects.chapter01.movie.condition.DiscountCondition;
import com.example.test.objects.chapter01.movie.domain.Money;
import com.example.test.objects.chapter01.movie.domain.Screening;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.ToString;

@ToString
public abstract class DefaultDiscountPolicy implements DiscountPolicy {

    private List<DiscountCondition> conditions = new ArrayList<>();

    public DefaultDiscountPolicy(DiscountCondition... conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    public Money calculateDiscountAmount(Screening screening) {
        for (DiscountCondition condition : conditions) {
            if (condition.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }

        return Money.ZERO;
    }

    abstract protected Money getDiscountAmount(Screening screening);

}

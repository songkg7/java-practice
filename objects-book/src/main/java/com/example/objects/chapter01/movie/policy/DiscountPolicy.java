package com.example.objects.chapter01.movie.policy;

import com.example.objects.chapter01.movie.condition.DiscountCondition;
import com.example.objects.chapter01.movie.domain.Money;
import com.example.objects.chapter01.movie.domain.Screening;
import java.util.Arrays;
import java.util.List;
import lombok.ToString;

@ToString
public abstract class DiscountPolicy {

    private final List<DiscountCondition> conditions;

    public DiscountPolicy(DiscountCondition... conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    /**
     * NOTE: NoneDiscountPolicy 의 경우 return 값에 상관없이 Money.ZERO 가 return 된다.
     * 개념이 일치하지 않는 현상으로 이에 따른 해결방법은 DiscountPolicy 를 interface 로 선언하는 것이다.
     */
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

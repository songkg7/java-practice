package com.example.test.objects.chapter01.movie.policy;

import com.example.test.objects.chapter01.movie.domain.Money;
import com.example.test.objects.chapter01.movie.domain.Screening;

public class NoneDiscountPolicy extends DiscountPolicy {

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }

}

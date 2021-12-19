package com.example.test.objects.chapter01.movie.condition;

import com.example.test.objects.chapter01.movie.domain.Screening;

public interface DiscountCondition {

    boolean isSatisfiedBy(Screening screening);

}

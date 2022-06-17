package com.example.objects.chapter01.movie.condition;

import com.example.objects.chapter01.movie.domain.Screening;

public interface DiscountCondition {

    boolean isSatisfiedBy(Screening screening);

}

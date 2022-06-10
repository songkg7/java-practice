package com.example.javapractice.objects.chapter01.movie.condition;

import com.example.javapractice.objects.chapter01.movie.domain.Screening;

public interface DiscountCondition {

    boolean isSatisfiedBy(Screening screening);

}

package com.example.test.objects.chapter01.movie.policy;

import com.example.test.objects.chapter01.movie.domain.Money;
import com.example.test.objects.chapter01.movie.domain.Screening;

public interface DiscountPolicy {

    Money calculateDiscountAmount(Screening screening);

}

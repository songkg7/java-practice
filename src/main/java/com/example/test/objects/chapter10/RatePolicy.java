package com.example.test.objects.chapter10;

import com.example.test.objects.chapter01.movie.domain.Money;

public interface RatePolicy {

    Money calculateFee(Phone phone);
}

package com.example.javapractice.objects.chapter10;

import com.example.javapractice.objects.chapter01.movie.domain.Money;

public interface RatePolicy {

    Money calculateFee(Phone phone);
}

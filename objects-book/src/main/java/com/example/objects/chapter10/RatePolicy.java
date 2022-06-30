package com.example.objects.chapter10;

import com.example.objects.chapter01.movie.domain.Money;
import com.example.objects.chapter10.domain.Phone;

public interface RatePolicy {

    Money calculateFee(Phone phone);
}

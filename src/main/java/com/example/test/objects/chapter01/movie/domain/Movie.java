package com.example.test.objects.chapter01.movie.domain;

import com.example.test.objects.chapter01.movie.policy.DiscountPolicy;
import java.time.Duration;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Movie {

    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy discountPolicy;

    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money getFee() {
        return fee;
    }

    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }

}
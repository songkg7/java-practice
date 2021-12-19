package com.example.test.objects.chapter01.movie.domain;

import static org.junit.jupiter.api.Assertions.*;

import com.example.test.objects.chapter01.movie.condition.PeriodCondition;
import com.example.test.objects.chapter01.movie.condition.SequenceCondition;
import com.example.test.objects.chapter01.movie.policy.AmountDiscountPolicy;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import org.junit.jupiter.api.Test;

class MovieTest {

    @Test
    void test_1() {
        Movie avatar = new Movie("Avatar", Duration.ofMinutes(120), Money.wons(10000),
                new AmountDiscountPolicy(Money.wons(800),
                        new SequenceCondition(1),
                        new SequenceCondition(10),
                        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59))));

        Screening screening = new Screening(avatar, 1, LocalDateTime.of(2022, 1, 1, 10, 0));

        Customer customer = new Customer("alex", 28);
        Reservation reservation = screening.reserve(customer, 4);

        System.out.println(reservation);

    }

}
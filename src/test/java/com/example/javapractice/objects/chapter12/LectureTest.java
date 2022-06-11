package com.example.javapractice.objects.chapter12;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class LectureTest {

    @Test
    void evaluate() {
        Lecture lecture = new Lecture("객체지향 프로그래밍", 70, List.of(81, 95, 75, 50, 45));

        String evaluate = lecture.evaluate();

        assertThat(evaluate).isEqualTo("Pass:3 Fail:2");
    }
}
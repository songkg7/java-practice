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

    @Test
    void override_evaluate() {
        Lecture lecture = new GradeLecture("객체지향 프로그래밍", 70,
                List.of(new Grade("A", 100, 95),
                        new Grade("B", 94, 80),
                        new Grade("C", 79, 70),
                        new Grade("D", 69, 50),
                        new Grade("F", 49, 0)),
                List.of(81, 95, 75, 50, 45));

        String evaluate = lecture.evaluate();

        assertThat(evaluate).isEqualTo("Pass:3 Fail:2, A:1 B:1 C:1 D:1 F:1");
    }
}
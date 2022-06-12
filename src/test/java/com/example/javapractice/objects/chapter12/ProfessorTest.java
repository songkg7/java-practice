package com.example.javapractice.objects.chapter12;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class ProfessorTest {

    @Test
    void compileStatistics() {
        Professor professor = new Professor("다익스트라", new GradeLecture("알고리즘",
                70,
                List.of(new Grade("A", 100, 95),
                        new Grade("B", 94, 80),
                        new Grade("C", 79, 70),
                        new Grade("D", 69, 50),
                        new Grade("F", 49, 0)),
                List.of(81, 95, 75, 50, 45)));

        String statistics = professor.compileStatistics();

        assertThat(statistics).isEqualTo("[다익스트라] Pass:3 Fail:2, A:1 B:1 C:1 D:1 F:1 - Avg: 69.2");
    }
}
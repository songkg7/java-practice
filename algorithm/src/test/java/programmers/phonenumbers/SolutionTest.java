package programmers.phonenumbers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    private final Solution1 s1 = new Solution1();

    @Test
    void case1() {
        String[] array = {"119", "97674223", "1195524421"};
        boolean answer = s1.solution(array);
        assertThat(answer).isFalse();
    }

    @Test
    void case2() {
        String[] array = {"12", "123", "1235", "567", "88"};
        boolean answer = s1.solution(array);
        assertThat(answer).isFalse();
    }

    @Test
    void case3() {
        String[] array = {"123", "456", "789"};
        boolean answer = s1.solution(array);
        assertThat(answer).isTrue();
    }

}

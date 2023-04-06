package programmers.phonenumbers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void case1() {
        String[] array = {"119", "97674223", "1195524421"};
        boolean answer = s.solution1(array);
        assertThat(answer).isFalse();
    }

    @Test
    void case2() {
        String[] array = {"12", "123", "1235", "567", "88"};
        boolean answer = s.solution1(array);
        assertThat(answer).isFalse();
    }

    @Test
    void case3() {
        String[] array = {"123", "456", "789"};
        boolean answer = s.solution1(array);
        assertThat(answer).isTrue();
    }

    @Test
    void case4() {
        String[] array = {"119", "97674223", "1195524421"};
        boolean answer = s.solution2(array);
        assertThat(answer).isFalse();
    }

    @Test
    void case5() {
        String[] array = {"12", "123", "1235", "567", "88"};
        boolean answer = s.solution2(array);
        assertThat(answer).isFalse();
    }

    @Test
    void case6() {
        String[] array = {"123", "456", "789"};
        boolean answer = s.solution2(array);
        assertThat(answer).isTrue();
    }
}

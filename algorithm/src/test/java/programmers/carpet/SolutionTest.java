package programmers.carpet;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void test1() {
        int[] actual = solution.solution(10, 2);
        assertThat(actual).containsExactly(4, 3);
    }

    @Test
    void test2() {
        int[] actual = solution.solution(8, 1);
        assertThat(actual).containsExactly(3, 3);
    }

    @Test
    void test3() {
        int[] actual = solution.solution(24, 24);
        assertThat(actual).containsExactly(8, 6);
    }
}

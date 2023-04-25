package programmers.biggestnumber;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void solution() {
        Solution solution = new Solution();
        assertThat(solution.solution(new int[]{6, 10, 2})).isEqualTo("6210");
    }

    @Test
    void solution2() {
        Solution solution = new Solution();
        assertThat(solution.solution(new int[]{3, 30, 34, 5, 9})).isEqualTo("9534330");
    }

    @Test
    void solution3() {
        Solution solution = new Solution();
        assertThat(solution.solution(new int[]{0, 0})).isEqualTo("0");
    }

}

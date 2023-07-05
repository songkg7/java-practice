package leetcode.longestsubarray;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void solution() {
        Solution solution = new Solution();
        int actual = solution.longestSubarray(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1});
        assertThat(actual).isEqualTo(5);
    }

    @Test
    @DisplayName("반드시 하나는 제거해야 하는 조건이 있다.")
    void solution_2() {
        Solution solution = new Solution();
        int actual = solution.longestSubarray(new int[]{1, 1, 1});
        assertThat(actual).isEqualTo(2);
    }

}

package leetcode.numberoflogestincreasingsubsequence;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void solution() {
        Solution solution = new Solution();
        int actual = solution.findNumberOfLIS(new int[]{1, 2, 4, 3, 5, 4, 7, 2});

        assertThat(actual).isEqualTo(3);
    }

    @Test
    void solution_1() {
        Solution solution = new Solution();
        int actual = solution.findNumberOfLIS(new int[]{1, 3, 5, 4, 7});

        assertThat(actual).isEqualTo(2);
    }

    @Test
    void solution_2() {
        Solution solution = new Solution();
        int actual = solution.findNumberOfLIS(new int[]{2,2,2,2,2});

        assertThat(actual).isEqualTo(5);
    }

}

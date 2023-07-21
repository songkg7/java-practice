package leetcode.longestincreasingsubsequence;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void solution() {
        Solution solution = new Solution();
        int actual = solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});

        assertThat(actual).isEqualTo(4);
    }

}

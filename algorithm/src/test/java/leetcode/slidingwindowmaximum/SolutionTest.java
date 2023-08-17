package leetcode.slidingwindowmaximum;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void test() {
        Solution solution = new Solution();
        int[] actual = solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        assertThat(actual).containsExactly(3, 3, 5, 5, 6, 7);
    }

}

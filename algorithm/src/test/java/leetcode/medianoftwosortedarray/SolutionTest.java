package leetcode.medianoftwosortedarray;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void solution() {
        Solution solution = new Solution();
        double actual = solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
        assertThat(actual).isEqualTo(2);
    }

    @Test
    void solution_2() {
        Solution solution = new Solution();
        double actual = solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        assertThat(actual).isEqualTo(2.5);
    }

}

package leetcode.nonoverlappingintervals;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void solution() {
        int[][] intervals = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        Solution solution = new Solution();
        int actual = solution.eraseOverlapIntervals(intervals);

        assertThat(actual).isEqualTo(1);
    }

}

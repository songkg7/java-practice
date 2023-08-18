package leetcode.maximalnetworkrank;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void test() {
        Solution solution = new Solution();
        int actual = solution.maximalNetworkRank(4, new int[][]{{0, 1}, {0, 3}, {1, 2}, {1, 3}});
        assertThat(actual).isEqualTo(4);
    }

}

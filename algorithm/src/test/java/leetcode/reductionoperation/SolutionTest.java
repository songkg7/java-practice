package leetcode.reductionoperation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void reductionOperations() {
        Solution solution = new Solution();
        int actual = solution.reductionOperations(new int[]{10, 10, 10, 10, 1, 10, 10, 10, 10, 10});
        assertThat(actual).isEqualTo(9);
    }
}

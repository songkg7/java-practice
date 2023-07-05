package leetcode.singlenumber2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void singleNumber() {
        Solution solution = new Solution();
        int actual = solution.singleNumber(new int[]{2, 2, 3, 2});
        assertThat(actual).isEqualTo(3);
    }
}

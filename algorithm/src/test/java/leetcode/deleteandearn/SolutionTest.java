package leetcode.deleteandearn;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void test() {
        Solution solution = new Solution();
        int answer = solution.deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4});

        assertThat(answer).isEqualTo(9);
    }

}

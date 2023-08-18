package leetcode.predictthewinner;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void solution() {
        Solution solution = new Solution();
        boolean actual = solution.predictTheWinner(new int[]{1, 5, 233, 7});

        assertThat(actual).isTrue();
    }
}

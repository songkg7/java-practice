package leetcode.asteroidcollision;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class SolutionTest {

    @Test
    void solution() {
        Solution solution = new Solution();
        int[] actual = solution.asteroidCollision(new int[]{10, 2, -5});

        assertThat(actual).containsExactly(10);
    }

}

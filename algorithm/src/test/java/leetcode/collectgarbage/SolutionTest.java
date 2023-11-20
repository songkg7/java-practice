package leetcode.collectgarbage;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void garbageCollection() {
        Solution solution = new Solution();
        int actual = solution.garbageCollection(new String[]{"G", "P", "GP", "GG"}, new int[]{2, 4, 3});
        assertThat(actual).isEqualTo(21);
    }
}

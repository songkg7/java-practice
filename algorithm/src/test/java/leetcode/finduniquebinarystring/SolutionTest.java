package leetcode.finduniquebinarystring;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void test() {
        Solution solution = new Solution();
        String actual = solution.findDifferentBinaryString(new String[]{"00", "01"});
        assertThat(actual).isIn("11", "10");
    }
}

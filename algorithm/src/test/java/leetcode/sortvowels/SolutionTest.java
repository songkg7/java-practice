package leetcode.sortvowels;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void sortVowels() {
        Solution solution = new Solution();
        String actual = solution.sortVowels("lEetcOde");
        assertThat(actual).isEqualTo("lEOtcede");
    }
}

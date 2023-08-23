package leetcode.reorganizestring;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @ParameterizedTest
    @CsvSource({
            "aab, aba",
            "baaba, ababa"
    })
    void test(String expected, String actual) {
        Solution solution = new Solution();
        String s = solution.reorganizeString(expected);
        assertThat(s).isEqualTo(actual);
    }

    @Test
    void test1() {
        Solution solution = new Solution();
        String s = solution.reorganizeString("aaab");
        assertThat(s).isBlank();
    }


}

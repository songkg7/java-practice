package leetcode.integertoroman;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @ParameterizedTest
    @CsvSource({
            "1994, MCMXCIV",
            "3, III",
            "58, LVIII"
    })
    void test(int num, String expected) {
        Solution solution = new Solution();
        String actual = solution.intToRoman(num);
        assertThat(actual).isEqualTo(expected);
    }

}

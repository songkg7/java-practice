package leetcode.longestpalindromsubstring;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @ParameterizedTest
    @CsvSource({
            "babad, bab",
            "cbbd, bb"
    })
    void solution(String s, String expected) {
        Solution solution = new Solution();
        String actual = solution.longestPalindrome(s);

        assertThat(actual).isEqualTo(expected);
    }

}

package leetcode.longestsubstring;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @ParameterizedTest
    @CsvSource({
            "abcabcbb, 3",
            "bbbbb, 1",
            "pwwkew, 3"
    })
    void solution(String s, int answer) {
        Solution solution = new Solution();
        int actual = solution.lengthOfLongestSubstring(s);
        assertThat(actual).isEqualTo(answer);
    }

}

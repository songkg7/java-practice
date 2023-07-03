package leetcode.buddystings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @ParameterizedTest
    @CsvSource({
            "abac, abad, false",
            "abcd, adcb, true",
            "ab, ba, true",
            "abcd, cbad, true",
            "ab, ab, false",
            "aa, aa, true",
    })
    void buddyStrings(String s, String goal, boolean expected) {
        Solution solution = new Solution();
        boolean actual = solution.buddyStrings(s, goal);
        assertThat(actual).isEqualTo(expected);
    }
}

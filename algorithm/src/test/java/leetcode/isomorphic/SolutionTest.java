package leetcode.isomorphic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    Solution solution = new Solution();

    @ParameterizedTest
    @CsvSource({
            "egg, add, true",
            "paper, title, true",
            "foo, bar, false",
            "badc, baba, false"
    })
    void solution(String s, String t, boolean expected) {
        boolean result = solution.isIsomorphic(s, t);
        assertThat(result).isEqualTo(expected);
    }

}

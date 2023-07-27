package leetcode.reverseinteger;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @ParameterizedTest
    @CsvSource({
            "123, 321",
            "-123, -321",
            "120, 21",
            "1534236469, 0",
            "-2147483648, 0"
    })
    void solution(int x, int expected) {
        Solution solution = new Solution();
        int actual = solution.reverse(x);

        assertThat(actual).isEqualTo(expected);
    }
}

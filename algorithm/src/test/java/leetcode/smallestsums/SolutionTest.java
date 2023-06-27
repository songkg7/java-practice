package leetcode.smallestsums;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void ksmallestSums_1() {
        Solution solution = new Solution();
        List<List<Integer>> actual = solution.kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3);

        assertThat(actual).containsExactly(List.of(1, 2), List.of(1, 4), List.of(1, 6));
    }

    @Test
    void ksmallestSums_2() {
        Solution solution = new Solution();
        List<List<Integer>> actual = solution.kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 2);

        assertThat(actual).containsExactly(List.of(1, 1), List.of(1, 1));
    }
}

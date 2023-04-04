package leetcode.mergesort;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    private final Solution s = new Solution();

    @Test
    void case1() {
        // given
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};

        // when
        s.merge(nums1, 3, nums2, 3);

        // then
        assertThat(nums1).containsExactly(1, 2, 2, 3, 5, 6);
    }

    @Test
    void case2() {
        // given
        int[] nums1 = {1};
        int[] nums2 = {};

        // when
        s.merge(nums1, 1, nums2, 0);

        // then
        assertThat(nums1).containsExactly(1);
    }

}

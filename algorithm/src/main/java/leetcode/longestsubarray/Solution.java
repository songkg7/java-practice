package leetcode.longestsubarray;

import java.util.Arrays;

public class Solution {

    public int longestSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int count = 0;

        while (right < nums.length) {
            int[] subArray = Arrays.copyOfRange(nums, left, right + 1);
            int oneCount = 0;
            int zeroCount = 0;
            for (int i : subArray) {
                if (i == 1) {
                    oneCount++;
                } else {
                    zeroCount++;
                }
            }
            if (zeroCount == 1) {
                count = Math.max(oneCount, count);
                right++;
            } else if (zeroCount == 0) {
                count = Math.max(oneCount - 1, count);
                right++;
            } else {
                left++;
            }
        }
        return count;
    }

}

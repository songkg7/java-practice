package leetcode.longestsubarray;

public class Solution {

    public int longestSubarray(int[] nums) {
        int left = 0;
        int count = 0;
        int zeroCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            }

            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            count = Math.max(count, i - left);
        }
        return count;
    }

}

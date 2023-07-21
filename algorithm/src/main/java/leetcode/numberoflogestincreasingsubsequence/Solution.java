package leetcode.numberoflogestincreasingsubsequence;

import java.util.Arrays;

public class Solution {

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        // 최대 길이, 카운트
        int[] length = new int[n];
        int[] count = new int[n];
        Arrays.fill(length, 1);
        Arrays.fill(count, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (length[j] + 1 > length[i]) {
                        length[i] = length[j] + 1;
                        count[i] = 0;
                    }
                    if (length[j] + 1 == length[i]) {
                        count[i] += count[j];
                    }
                }
            }
        }

        int maxLength = 0;
        int result = 0;

        for (int len : length) {
            maxLength = Math.max(len, maxLength);
        }
        for (int i = 0; i < n; i++) {
            if (length[i] == maxLength) {
                result += count[i];
            }
        }
        return result;
    }

}

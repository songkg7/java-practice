package leetcode.deleteandearn;

public class Solution {

    public int deleteAndEarn(int[] nums) {
        int[] values = new int[10001];
        for (int num : nums) {
            values[num] += num;
        }
        int prev = 0, skip = 0;
        for (int current : values) {
            int temp = Math.max(skip + current, prev); // Math.max(dp[i-1], dp[i-2] + current)
            skip = prev;
            prev = temp;
        }
        return prev;
    }
    
}

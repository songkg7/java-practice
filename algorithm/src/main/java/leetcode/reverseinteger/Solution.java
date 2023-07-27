package leetcode.reverseinteger;

public class Solution {
    public int reverse(int x) {
        int answer = 0;
        while (x != 0) {
            int overflowCheck = x % 10 + answer * 10;
            if ((overflowCheck - x % 10) / 10 != answer) {
                return 0;
            }

            x /= 10;
            answer = overflowCheck;
        }
        return answer;
    }
}

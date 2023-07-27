package leetcode.reverseinteger;

public class Solution {
    public int reverse(int x) {
        String s = String.valueOf(x);
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '-') {
                sb.insert(0, s.charAt(i));
                continue;
            }
            sb.append(s.charAt(i));
        }
        String ans = sb.toString();
        if (Long.parseLong(ans) > Integer.MAX_VALUE || Long.parseLong(ans) < Integer.MIN_VALUE) {
            return 0;
        }
        return Integer.parseInt(ans);
    }
}

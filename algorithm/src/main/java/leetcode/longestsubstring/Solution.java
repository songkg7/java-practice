package leetcode.longestsubstring;

import java.util.LinkedList;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        char[] charArray = s.toCharArray();
        int start = 0;
        int max = 0;
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < charArray.length; i++) {
            String c = String.valueOf(charArray[i]);
            while (list.contains(c)) {
                start++;
                list.removeFirst();
            }
            list.add(c);
            max = Math.max(max, i - start + 1);
        }
        return max;
    }

}

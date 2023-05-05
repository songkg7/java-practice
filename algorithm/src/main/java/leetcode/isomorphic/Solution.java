package leetcode.isomorphic;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i)) && map.containsValue(t.charAt(i))) {
                return false;
            }
            Character value = map.putIfAbsent(s.charAt(i), t.charAt(i));
            if (value != null && value != t.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}

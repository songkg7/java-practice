package leetcode.buddystings;

import java.util.*;

public class Solution {

    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        if (s.equals(goal)) {
            Set<Character> set = new HashSet<>();
            for (char c : s.toCharArray()) {
                set.add(c);
            }
            return set.size() < goal.length();
        }

        char[] arr1 = s.toCharArray();
        char[] arr2 = goal.toCharArray();
        List<Integer> diffIndexes = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                diffIndexes.add(i);
            }
        }

        if (diffIndexes.size() != 2) {
            return false;
        }

        char temp = arr1[diffIndexes.get(0)];
        arr1[diffIndexes.get(0)] = arr1[diffIndexes.get(1)];
        arr1[diffIndexes.get(1)] = temp;

        return Arrays.equals(arr1, arr2);
    }

}

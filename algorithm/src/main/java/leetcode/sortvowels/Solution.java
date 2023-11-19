package leetcode.sortvowels;

import java.util.*;

class Solution {
    public String sortVowels(String s) {
        Set<Character> vowels = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] chars = s.toCharArray();
        char[] newChars = new char[chars.length];

        // vowels position
        Deque<Character> queue = new ArrayDeque<>();
        for (int i = 0; i < chars.length; i++) {
            if (vowels.contains(chars[i])) {
                queue.offer(chars[i]);
            } else {
                newChars[i] = chars[i];
            }
        }
        List<Character> sorted = queue.stream().sorted().toList();

        int idx = 0;
        for (int i = 0; i < newChars.length; i++) {
            if (newChars[i] == '\u0000') {
                newChars[i] = sorted.get(idx++);
            }
        }

        return String.valueOf(newChars);
    }
}

package programmers.phonenumbers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    public boolean solution(String[] phone_book) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], i);
        }

        for (String s : phone_book) {
            for (int j = 1; j < s.length(); j++) {
                if (map.containsKey(s.substring(0, j))) {
                    return false;
                }
            }
        }
        return true;
    }
}

class Solution2 {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }
        return true;
    }
}

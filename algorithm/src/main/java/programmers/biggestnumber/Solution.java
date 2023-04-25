package programmers.biggestnumber;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

class Solution {

    public String solution(int[] numbers) {
        String result = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted(Comparator.<String, String>comparing(s -> s.repeat(3)).reversed())
                .collect(Collectors.joining());

        return result.charAt(0) == '0' ? "0" : result;
    }

}

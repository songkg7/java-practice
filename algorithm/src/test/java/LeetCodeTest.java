import static org.assertj.core.api.Assertions.assertThat;

import java.util.Stack;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LeetCodeTest {

    @Test
    void validParentheses() {
        String s = "{[]}";

        String[] chars = s.split("");
        Stack<String> result = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (i == 0) {
                result.add(chars[i]);
                continue;
            }
            String lastElement = result.pop();
            if (chars[i].equals(")") && lastElement.equals("(")) {
                continue;
            }
            if (chars[i].equals("]") && lastElement.equals("[")) {
                continue;
            }
            if (chars[i].equals("}") && lastElement.equals("{")) {
                continue;
            }
            result.add(lastElement);
            result.add(chars[i]);
        }

        assertThat(result).isEmpty();
    }

    @ParameterizedTest
    @ValueSource(strings = { "{[]}", "()", "()[]{}" })
    void validParentheses_2(String s) {
        Stack<Character> stack = new Stack<>();
        boolean result;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                result = false;
            }
        }
        result = stack.isEmpty();

        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = { "{[]}", "()", "()[]{}" })
    void validParentheses_3(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> result = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (i == 0 || result.isEmpty()) {
                result.push(chars[i]);
                continue;
            }
            char lastElement = result.pop();
            if (chars[i] == ')' && lastElement == '(') {
                continue;
            }
            if (chars[i] == ']' && lastElement == '[') {
                continue;
            }
            if (chars[i] == '}' && lastElement == '{') {
                continue;
            }
            result.push(lastElement);
            result.push(chars[i]);
        }

        assertThat(result).isEmpty();
    }

    @Test
    void searchInsertTest() {
        int[] nums = { 1, 3, 5, 6 };
        int target = 6;
        // return 2
        int answer = searchInsert(nums, target);

        assertThat(answer).isEqualTo(3);
    }

    private int searchInsert(int[] nums, int target) {
        // index
        int low = 0;
        int mid;
        int high = nums.length - 1;

        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            }
        }
        return low; // 찾고자 하는 원소가 없을 때
    }

    @ParameterizedTest
    @ValueSource(strings = { "    fly  to the moon " })
    void regexpTest(String s) {
        int answer = lastWordLength(s);
        assertThat(answer).isEqualTo(4);
    }

    private int lastWordLength(String s) {
        String[] arr = s.trim().split(" ");
        return arr[arr.length - 1].length();
    }

}

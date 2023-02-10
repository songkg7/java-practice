import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigInteger;
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

    @Test
    void plusOneTest() {
        int[] result = plusOne(new int[]{ 1, 2, 3 });
        assertThat(result).containsExactly(1, 2, 4);
    }

    private int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            if (digits[i] < 10) {
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    @Test
    void addBinaryTest() {
        String answer = addBinary2("11", "1");

        assertThat(answer).isEqualTo("100");
    }

    private String addBinary(String a, String b) {
        BigInteger ba = new BigInteger(a, 2);
        BigInteger bb = new BigInteger(b, 2);
        return ba.add(bb).toString(2);
    }

    private String addBinary2(String a, String b) {
        int aIdx = a.length() - 1;
        int bIdx = b.length() - 1;

        int sum = 0;
        StringBuilder sb = new StringBuilder();

        while (aIdx >= 0 || bIdx >= 0) {
            if (aIdx >= 0) {
                sum += a.charAt(aIdx--) - '0'; // subtract by '0' to convert the numbers from a char
            }
            if (bIdx >= 0) {
                sum += b.charAt(bIdx--) - '0';
            }

            sb.append(sum % 2); // 비교 자리수가 모두 1 이여서 합계가 2가 될 경우 0 을 넣고 다음 자리를 계산할 때 1 을 추가
            sum /= 2;
        }

        if (sum == 1) {
            sb.append(sum);
        }
        return sb.reverse().toString();
    }

    @Test
    void sqrtTest() {
        int answer = sqrt(16);

        System.out.println("answer: " + answer);
    }

    private int sqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int low = 1;
        int high = x;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid <= x / mid && x / (mid + 1) < (mid + 1)) {
                return mid;
            }
            if (mid <= x / mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    // LeetCode 70
    @Test
    void climbingStairTest() {
        int answer = climbingStairs(3);
        System.out.println("answer: " + answer);
    }

    private int climbingStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] fibonacci = new int[n + 1];
        fibonacci[1] = 1;
        fibonacci[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            fibonacci[i] = fibonacci[i - 2] + fibonacci[i - 1];
        }
        return fibonacci[n];
    }

}

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

}

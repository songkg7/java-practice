import static org.assertj.core.api.Assertions.assertThat;

import java.util.Stack;
import org.junit.jupiter.api.Test;

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

}

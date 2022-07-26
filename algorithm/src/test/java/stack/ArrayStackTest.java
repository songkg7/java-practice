package stack;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ArrayStackTest {

    @Test
    void isEmpty() {
        ArrayStack stack = new ArrayStack();
        boolean b = stack.isEmpty();

        assertThat(b).isTrue();
    }

    @Test
    void isFull() {
        ArrayStack stack = new ArrayStack();
        stack.push(1);

        boolean b = stack.isFull();

        assertThat(b).isTrue();
    }

    @Test
    void pushAndPop() {
        ArrayStack stack = new ArrayStack();
        int expected = 1;
        stack.push(expected);

        int actual = stack.pop();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void clear() {
        ArrayStack stack = new ArrayStack();
        stack.push(1);

        stack.clear();

        assertThat(stack.isEmpty()).isTrue();
    }
}

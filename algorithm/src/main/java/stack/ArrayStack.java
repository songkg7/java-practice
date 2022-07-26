package stack;

/**
 * 스택 크기의 최대 값이 미리 정해져야 하고 바뀔 수 없다. 꽉 찬 스택에 새 항목을 푸시하려 하면 이 구현에만 관련된 예외가 발생한다.
 */
public class ArrayStack implements Stack {

    private int top;
    private int capacity;
    private int[] array;

    public ArrayStack() {
        this.capacity = 1;
        this.array = new int[capacity];
        this.top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    @Override
    public void push(int data) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            return;
        }
        array[++top] = data;
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return 0;
        }
        return array[top--];
    }

    public void clear() {
        top = -1;
    }
}

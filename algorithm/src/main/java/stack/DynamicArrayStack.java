package stack;

public class DynamicArrayStack implements Stack {
    private int top;
    private int capacity;
    private int[] array;

    public DynamicArrayStack() {
        this.capacity = 1;
        this.array = new int[capacity];
        this.top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isStackFull() {
        return top == capacity - 1;
    }

    @Override
    public void push(int data) {
        if (isStackFull()) {
            doubleStack();
        }
        array[++top] = data;
    }

    private void doubleStack() {
        int[] newArray = new int[capacity * 2];
        System.arraycopy(array, 0, newArray, 0, capacity);
        capacity *= 2;
        array = newArray;
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return 0;
        }
        return array[top--];
    }

    public void clear() {
        top = -1;
    }
}

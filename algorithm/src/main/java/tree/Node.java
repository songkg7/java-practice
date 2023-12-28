package tree;

public class Node<T> {

    T val;
    Node<T> left;
    Node<T> right;

    public Node(T val) {
        this.val = val;
    }

    public T getVal() {
        return val;
    }

    public Node<T> getLeft() {
        return left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void addLeft(Node<T> node) {
        this.left = node;
    }

    public void addRight(Node<T> node) {
        this.right = node;
    }
}

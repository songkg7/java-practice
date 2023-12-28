package tree;

import java.util.Comparator;
import java.util.List;

public class BinaryTree<T> {
    private int count;

    Node<T> root;
    Comparator<T> comparator;

    public BinaryTree(T val, Comparator<T> comparator) {
        this.root = new Node<>(val);
        this.count = 1;
        this.comparator = comparator;
    }

    public boolean add(T val) {
        // if node greater than root.tVal, node is determined to be the right child.
        // 어느 위치에 삽입해야하는지 찾아야 한다. search
        Node<T> target = search(val);
        if (target != null) {
            return false;
        }

        Node<T> newNode = new Node<>(val);
        Node<T> cur = root;
        Node<T> parent;
        while (true) {
            parent = cur;
            if (comparator.compare(cur.val, val) > 0) {
                cur = cur.right;
                if (cur == null) {
                    parent.addRight(newNode);
                    count++;
                    return true;
                }
            } else if (comparator.compare(cur.val, val) < 0) {
                cur = cur.left;
                if (cur == null) {
                    parent.addLeft(newNode);
                    count++;
                    return true;
                }
            }
        }
    }

    public Node<T> search(T val) {
        // 트리 탐색
        Node<T> cur = root;
        while (cur != null) {
            if (comparator.compare(cur.val, val) == 0) {
                return cur;
            }
            if (comparator.compare(cur.val, val) > 0) {
                cur = cur.right;
            } else if (comparator.compare(cur.val, val) < 0) {
                cur = cur.left;
            }
        }

        return null;
    }

    public int size() {
        return count;
    }

    public List<T> inOrderTraverse(Node<T> focusNode, List<T> result) {
        if (focusNode != null) {
            // 중위 탐색 = 오름차순 정렬
            inOrderTraverse(focusNode.left, result);
            result.add(focusNode.val);
            inOrderTraverse(focusNode.right, result);
        }
        return result;
    }
}

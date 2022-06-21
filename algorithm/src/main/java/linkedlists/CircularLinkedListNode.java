package linkedlists;

public class CircularLinkedListNode {
    private int data;
    private CircularLinkedListNode next;
    private CircularLinkedListNode prev;

    public CircularLinkedListNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public CircularLinkedListNode getNext() {
        return next;
    }

    public void setNext(CircularLinkedListNode next) {
        this.next = next;
    }

    public CircularLinkedListNode getPrev() {
        return prev;
    }

    public void setPrev(CircularLinkedListNode prev) {
        this.prev = prev;
    }

    public int length(CircularLinkedListNode headNode) {
        int length = 0;
        CircularLinkedListNode currNode = headNode;
        while (currNode != null) {
            length++;
            currNode = currNode.getNext();
            if (currNode == headNode) {
                break;
            }
        }
        return length;
    }
}

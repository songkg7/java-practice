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

    public void printCircularListData(CircularLinkedListNode headNode) {
        CircularLinkedListNode curNode = headNode;
        while (curNode != null) {
            System.out.println(curNode.getData() + "->");
            curNode = curNode.getNext();
            if (curNode == headNode) {
                break;
            }
        }
        System.out.println("(" + curNode.getData() + ")headNode");
    }

    public CircularLinkedListNode insert(CircularLinkedListNode headNode, CircularLinkedListNode nodeToInsert,
            int position) {
        if (headNode == null) {
            return nodeToInsert;
        }

        // 가장 끝에 노드 삽입하기
        CircularLinkedListNode curNode = headNode;
        while (curNode.getNext() != headNode) {
            curNode = curNode.getNext();
        }
        nodeToInsert.setNext(headNode);
        curNode.setNext(nodeToInsert);
        return headNode;
    }
}

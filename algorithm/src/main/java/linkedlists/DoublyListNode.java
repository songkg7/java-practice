package linkedlists;

public class DoublyListNode {

    private int data;
    private DoublyListNode next;
    private DoublyListNode prev;

    public DoublyListNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DoublyListNode getNext() {
        return next;
    }

    public void setNext(DoublyListNode next) {
        this.next = next;
    }

    public DoublyListNode getPrev() {
        return prev;
    }

    public void setPrev(DoublyListNode prev) {
        this.prev = prev;
    }

    /**
     *
     * @param headNode
     * @param nodeToInsert
     * @param position
     * @return headNode
     */
    public DoublyListNode insert(DoublyListNode headNode, DoublyListNode nodeToInsert, int position) {
        if (position == 1) {
            nodeToInsert.setNext(headNode);
            nodeToInsert.setPrev(null);
            headNode.setPrev(nodeToInsert);
            return nodeToInsert;
        }

        DoublyListNode prevNode = headNode;
        int count = 1;
        while (count < position - 1) {
            prevNode = prevNode.getNext();
            count++;
        }
        DoublyListNode nextNode = prevNode.getNext();
        nodeToInsert.setNext(nextNode);
        if (nextNode != null) {
            nextNode.setPrev(nodeToInsert);
        }
        prevNode.setNext(nodeToInsert);
        nodeToInsert.setPrev(prevNode);
        return headNode;
    }

    public DoublyListNode delete(DoublyListNode headNode, int position) {
        if (position == 1) {
            DoublyListNode nextNode = headNode.getNext();
            nextNode.setPrev(null);
            headNode.setNext(null);
            return nextNode;
        }

        DoublyListNode prevNode = headNode;
        int count = 1;
        while (count < position - 1) {
            prevNode = prevNode.getNext();
            count++;
        }
        DoublyListNode targetNode = prevNode.getNext();
        prevNode.setNext(targetNode.getNext());
        targetNode.setPrev(null);
        if (targetNode.getNext() != null) {
            targetNode.getNext().setPrev(prevNode);
        }
        targetNode.setNext(null);
        return headNode;
    }
}

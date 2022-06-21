package linkedlists;

public class DoublyLinkedListNode {

    private int data;
    private DoublyLinkedListNode next;
    private DoublyLinkedListNode prev;

    public DoublyLinkedListNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DoublyLinkedListNode getNext() {
        return next;
    }

    public void setNext(DoublyLinkedListNode next) {
        this.next = next;
    }

    public DoublyLinkedListNode getPrev() {
        return prev;
    }

    public void setPrev(DoublyLinkedListNode prev) {
        this.prev = prev;
    }

    /**
     *
     * @param headNode
     * @param nodeToInsert
     * @param position
     * @return headNode
     */
    public DoublyLinkedListNode insert(DoublyLinkedListNode headNode, DoublyLinkedListNode nodeToInsert, int position) {
        if (position == 1) {
            nodeToInsert.setNext(headNode);
            nodeToInsert.setPrev(null);
            headNode.setPrev(nodeToInsert);
            return nodeToInsert;
        }

        DoublyLinkedListNode prevNode = headNode;
        int count = 1;
        while (count < position - 1) {
            prevNode = prevNode.getNext();
            count++;
        }
        DoublyLinkedListNode nextNode = prevNode.getNext();
        nodeToInsert.setNext(nextNode);
        if (nextNode != null) {
            nextNode.setPrev(nodeToInsert);
        }
        prevNode.setNext(nodeToInsert);
        nodeToInsert.setPrev(prevNode);
        return headNode;
    }

    public DoublyLinkedListNode delete(DoublyLinkedListNode headNode, int position) {
        if (position == 1) {
            DoublyLinkedListNode nextNode = headNode.getNext();
            nextNode.setPrev(null);
            headNode.setNext(null);
            return nextNode;
        }

        DoublyLinkedListNode prevNode = headNode;
        int count = 1;
        while (count < position - 1) {
            prevNode = prevNode.getNext();
            count++;
        }
        DoublyLinkedListNode targetNode = prevNode.getNext();
        prevNode.setNext(targetNode.getNext());
        targetNode.setPrev(null);
        if (targetNode.getNext() != null) {
            targetNode.getNext().setPrev(prevNode);
        }
        targetNode.setNext(null);
        return headNode;
    }
}

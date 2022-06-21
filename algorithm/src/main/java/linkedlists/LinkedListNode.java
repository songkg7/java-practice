package linkedlists;

public class LinkedListNode {
    private int data;
    private LinkedListNode next;

    public LinkedListNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public LinkedListNode getNext() {
        return next;
    }

    public void setNext(LinkedListNode next) {
        this.next = next;
    }

    int listLength(LinkedListNode headNode) {
        int length = 0;
        LinkedListNode currentNode = headNode;
        while (currentNode != null) {
            length++;
            currentNode = currentNode.getNext();
        }
        return length;
    }

    LinkedListNode insert(LinkedListNode headNode, LinkedListNode nodeToInsert, int position) {
        if (headNode == null) {
            return nodeToInsert;
        }

        int size = listLength(headNode);
        if (position > size + 1 || position < 1) {
            throw new IllegalArgumentException("Position of node to insert is invalid. The valid inputs are 1 to " + (size + 1));
        }

        if (position == 1) { // 리스트의 첫번째 위치로 노드 삽입
            nodeToInsert.setNext(headNode);
            return nodeToInsert;
        }

        LinkedListNode prevNode = headNode;
        int count = 1;
        while (count < position - 1) {
            prevNode = prevNode.getNext();
            count++;
        }
        LinkedListNode curNode = prevNode.getNext();
        nodeToInsert.setNext(curNode); // 새 노드의 다음 포인터가 현재 노드를 가리키도록 업데이트
        prevNode.setNext(nodeToInsert); // 이전 노드가 새 노드를 가리키도록 업데이트
        return headNode;
    }

    /**
     * 시간 복잡도: O(n)
     * @param headNode 연결 리스트의 headNode
     * @param position 삭제할 위치
     * @return headNode
     */
    LinkedListNode delete(LinkedListNode headNode, int position) {
        int size = listLength(headNode);

        if (position > size + 1 || position < 1) {
            throw new IllegalArgumentException("Position of node to delete is invalid. The valid inputs are 1 to " + (size + 1));
        }

        if (position == 1) {
            LinkedListNode nextNode = headNode.getNext();
            headNode.setNext(null);
            return nextNode;
        }

        LinkedListNode prevNode = headNode;
        int count = 1;
        while (count < position - 1) {
            prevNode = prevNode.getNext();
            count++;
        }
        LinkedListNode curNode = prevNode.getNext();
        prevNode.setNext(curNode.getNext());
        return headNode;
    }
}

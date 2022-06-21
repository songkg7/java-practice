package linkedlists;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DoublyLinkedListNodeTest {

    private DoublyLinkedListNode headNode;

    @BeforeEach
    void setUp() {
        headNode = new DoublyLinkedListNode(0);
        DoublyLinkedListNode dNode1 = new DoublyLinkedListNode(1);
        DoublyLinkedListNode dNode2 = new DoublyLinkedListNode(2);
        headNode.setNext(dNode1);
        dNode1.setNext(dNode2);
        dNode1.setPrev(headNode);
        dNode2.setPrev(dNode1);
    }

    @Test
    @DisplayName("이중 연결 리스트의 첫번째 위치 삽입")
    void insert_first() {
        DoublyLinkedListNode dNode3 = new DoublyLinkedListNode(3);
        headNode.insert(headNode, dNode3, 1);

        int next = dNode3.getNext().getData();

        assertThat(next).isEqualTo(0);
    }

    @Test
    @DisplayName("이중 연결 리스트의 삽입")
    void insert() {
        DoublyLinkedListNode dNode3 = new DoublyLinkedListNode(3);
        headNode.insert(headNode, dNode3, 3);

        int prev = dNode3.getPrev().getData();
        int next = dNode3.getNext().getData();

        assertThat(prev).isEqualTo(1);
        assertThat(next).isEqualTo(2);
    }

    @Test
    @DisplayName("이중 연결 리스트의 마지막 위치 삽입")
    void insert_last() {
        DoublyLinkedListNode dNode3 = new DoublyLinkedListNode(3);
        headNode.insert(headNode, dNode3, 4);

        int prev = dNode3.getPrev().getData();
        DoublyLinkedListNode next = dNode3.getNext();

        assertThat(prev).isEqualTo(2);
        assertThat(next).isNull();
    }

    @Test
    @DisplayName("이중 연결 리스트의 첫번째 위치 삭제")
    void delete_first() {
        DoublyLinkedListNode updatedHead = headNode.delete(headNode, 1);
        int data = updatedHead.getData();

        assertThat(data).isEqualTo(1);
    }

    @Test
    @DisplayName("이중 연결 리스트의 삭제")
    void delete() {
        headNode.delete(headNode, 2);
        int data = headNode.getNext().getData();

        assertThat(data).isEqualTo(2);
    }

    @Test
    @DisplayName("이중 연결 리스트의 마지막 위치 삭제")
    void delete_last() {
        headNode.delete(headNode, 3);
        DoublyLinkedListNode next = headNode.getNext().getNext();

        assertThat(next).isNull();
    }
}
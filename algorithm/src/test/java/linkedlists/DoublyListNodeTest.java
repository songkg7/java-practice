package linkedlists;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DoublyListNodeTest {

    private DoublyListNode headNode;

    @BeforeEach
    void setUp() {
        headNode = new DoublyListNode(0);
        DoublyListNode dNode1 = new DoublyListNode(1);
        DoublyListNode dNode2 = new DoublyListNode(2);
        headNode.setNext(dNode1);
        dNode1.setNext(dNode2);
        dNode1.setPrev(headNode);
        dNode2.setPrev(dNode1);
    }

    @Test
    @DisplayName("이중 연결 리스트의 첫번째 위치 삽입")
    void insert_first() {
        DoublyListNode dNode3 = new DoublyListNode(3);
        headNode.insert(headNode, dNode3, 1);

        int next = dNode3.getNext().getData();

        assertThat(next).isEqualTo(0);
    }

    @Test
    @DisplayName("이중 연결 리스트의 삽입")
    void insert() {
        DoublyListNode dNode3 = new DoublyListNode(3);
        headNode.insert(headNode, dNode3, 3);

        int prev = dNode3.getPrev().getData();
        int next = dNode3.getNext().getData();

        assertThat(prev).isEqualTo(1);
        assertThat(next).isEqualTo(2);
    }

    @Test
    @DisplayName("이중 연결 리스트의 마지막 위치 삽입")
    void insert_last() {
        DoublyListNode dNode3 = new DoublyListNode(3);
        headNode.insert(headNode, dNode3, 4);

        int prev = dNode3.getPrev().getData();
        DoublyListNode next = dNode3.getNext();

        assertThat(prev).isEqualTo(2);
        assertThat(next).isNull();
    }
}
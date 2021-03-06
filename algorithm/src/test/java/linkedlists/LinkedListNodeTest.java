package linkedlists;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LinkedListNodeTest {

    private LinkedListNode headNode;

    @BeforeEach
    void setUp() {
        headNode = new LinkedListNode(0);
        LinkedListNode listNode1 = new LinkedListNode(1);
        LinkedListNode listNode2 = new LinkedListNode(2);
        headNode.setNext(listNode1);
        listNode1.setNext(listNode2);
    }

    @Test
    @DisplayName("연결 리스트의 전체 길이")
    void listLength() {
        int length = headNode.listLength(headNode);
        assertThat(length).isEqualTo(3);
    }

    @Test
    @DisplayName("연결 리스트에 노드 삽입하기")
    void insert() {
        LinkedListNode listNode3 = new LinkedListNode(3);

        LinkedListNode node = headNode.insert(headNode, listNode3, 2);
        int data = node.getNext().getData();
        assertThat(data).isEqualTo(3);
    }

    @Test
    @DisplayName("연결 리스트의 첫번째 노드 삭제하기")
    void delete() {
        headNode = headNode.delete(headNode, 1);
        int length = headNode.listLength(headNode);
        int data = headNode.getData();

        assertThat(length).isEqualTo(2);
        assertThat(data).isEqualTo(1);
    }

    @Test
    @DisplayName("연결 리스트의 마지막 노드 삭제하기")
    void deleteLast() {
        headNode = headNode.delete(headNode, 3);
        int length = headNode.listLength(headNode);

        assertThat(length).isEqualTo(2);
    }

    @Test
    @DisplayName("연결 리스트의 중간 노드 삭제하기")
    void deleteAnywhere() {
        headNode = headNode.delete(headNode, 2);
        int data = headNode.getNext().getData();

        assertThat(data).isEqualTo(2);
    }
}
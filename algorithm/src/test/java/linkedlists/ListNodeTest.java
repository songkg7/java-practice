package linkedlists;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ListNodeTest {

    @Test
    @DisplayName("연결 리스트의 전체 길이")
    void listLength() {
        ListNode headNode = new ListNode(0);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        headNode.setNext(listNode1);
        listNode1.setNext(listNode2);

        int length = listNode2.listLength(headNode);
        assertThat(length).isEqualTo(3);
    }

    @Test
    @DisplayName("연결 리스트의 가장 처음에 노드 삽입하기")
    void insertHead() {
        ListNode headNode = new ListNode(0);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        headNode.setNext(listNode1);
        listNode1.setNext(listNode2);

        int length = listNode1.listLength(headNode);
        assertThat(length).isEqualTo(3);

        // 새 노드의 다음 노드로 기존 헤드노드를 삽입한다.
        ListNode listNode3 = new ListNode(3);
        listNode3.setNext(headNode); // 새 노드의 다음 포인터를 현재의 '머리'를 가리키도록 업데이트
        headNode = listNode3; // '머리' 노드 포인터가 새 노드를 가리키도록 업데이트

        int updatedLength = headNode.listLength(listNode3);
        assertThat(updatedLength).isEqualTo(4);
    }

    @Test
    @DisplayName("연결 리스트의 가장 마지막에 노드 삽입하기")
    void insertTail() {
        ListNode headNode = new ListNode(0);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        headNode.setNext(listNode1);
        listNode1.setNext(listNode2);

        int length = headNode.listLength(headNode);
        assertThat(length).isEqualTo(3);

        ListNode listNode3 = new ListNode(3);
        listNode2.setNext(listNode3);

        int updatedLength = listNode2.listLength(headNode);
        assertThat(updatedLength).isEqualTo(4);
    }

    @Test
    @DisplayName("위치 상관없이 연결 리스트에 노드 삽입하기")
    void insert() {
        ListNode headNode = new ListNode(0);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        headNode.setNext(listNode1);
        listNode1.setNext(listNode2);

        ListNode listNode3 = new ListNode(3);

        ListNode node = headNode.insert(headNode, listNode3, 2);
        int data = node.getNext().getData();
        assertThat(data).isEqualTo(3);
    }
}
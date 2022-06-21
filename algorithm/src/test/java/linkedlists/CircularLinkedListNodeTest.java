package linkedlists;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CircularLinkedListNodeTest {

    private CircularLinkedListNode headNode;

    @BeforeEach
    void setUp() {
        headNode = new CircularLinkedListNode(0);
        CircularLinkedListNode node1 = new CircularLinkedListNode(1);
        CircularLinkedListNode node2 = new CircularLinkedListNode(2);
        headNode.setNext(node1);
        headNode.setPrev(node2);
        node1.setNext(node2);
        node1.setPrev(headNode);
        node2.setNext(headNode);
        node2.setPrev(node1);
    }

    @Test
    void length() {
        int length = headNode.length(headNode);
        assertThat(length).isEqualTo(3);
    }
}
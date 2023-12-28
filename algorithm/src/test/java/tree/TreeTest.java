package tree;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TreeTest {

    @Test
    @DisplayName("기본 트리 구조")
    void basic() {
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);

        node1.addLeft(node2);
        node1.addRight(node3);

        assertThat(node1.getLeft()).isEqualTo(node2);
        assertThat(node1.getRight()).isEqualTo(node3);
    }
}

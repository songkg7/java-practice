package tree;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryTreeTest {

    @Test
    @DisplayName("바이너리트리에서 노드를 탐색한다")
    void search() {
        BinaryTree<Integer> tree = new BinaryTree<>(3, Comparator.comparingInt(o -> -o));
        tree.add(1);
        tree.add(5);

        Node<Integer> node = tree.search(5);

        assertThat(node.val).isEqualTo(5);
        assertThat(tree.size()).isEqualTo(3);
    }

    @Test
    void add() {

    }

    @Test
    void delete() {

    }

}

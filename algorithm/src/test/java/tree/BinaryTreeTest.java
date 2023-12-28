package tree;

import com.navercorp.fixturemonkey.FixtureMonkey;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryTreeTest {

    private final FixtureMonkey fixture = FixtureMonkey.create();

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
    void inOrderTraverse() {
        List<Integer> integers = fixture.giveMeBuilder(Integer.class)
                .sampleList(10);
        BinaryTree<Integer> tree = new BinaryTree<>(1, Comparator.reverseOrder());
        for (Integer integer : integers) {
            tree.add(integer);
        }

        List<Integer> traverse = tree.inOrderTraverse(tree.root, new ArrayList<>());
        System.out.println("traverse: " + traverse);

        assertThat(traverse).isNotEmpty();
    }
}

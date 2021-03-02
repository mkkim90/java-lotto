package basic;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NAryTreePreorderTraversalTest {
    @Test
    void solution() {
        Node child1= new Node(5);
        Node child2 = new Node(6);
        List<Node> childrenOfChild3 = Arrays.asList(child1, child2);
        Node child3 = new Node(3, childrenOfChild3);
        Node child4 = new Node(2);
        List<Node> childrenOfRoot = Arrays.asList(child3, child4);
        Node root = new Node(1, childrenOfRoot);

        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        assertThat(result).containsExactly(1,3,5,6,2);
    }

    private void traverse(Node root, List<Integer> result) {
        if (root == null) return;

        result.add(root.val());
        for (Node child : root.children()) {
            traverse(child, result);
        }
    }
}

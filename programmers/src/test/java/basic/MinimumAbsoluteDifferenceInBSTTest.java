package basic;

import org.junit.jupiter.api.Test;
import javax.swing.tree.TreeNode;


/**
 * 이진검색트리
 * preorder self left right
 * inorder left self right
 * postorder left right self
 * inorder -> 오름차순 정렬이 됨
 */
public class MinimumAbsoluteDifferenceInBSTTest {
    boolean init;
    int min;
    int prev;

    @Test
    void getMinimumDifference(TreeNode root) {
        init = false;
        min = Integer.MAX_VALUE;
        inorder(root);
    }

    public void inorder(TreeNode root) {
        /*if (root == null) return;
        //left
        inorder(root.left);
        //self
        if(!init) {
            init = true;
        } else {
            min = Math.min(min, root.val-prev);
        }
        //right
        prev = root.val;
        inorder(root.right)
        */
    }
}

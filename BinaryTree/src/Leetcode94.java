import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Leetcode 94 - Binary Tree Inorder Traversal
 */
public class Leetcode94 {
    /**
     * Iterative Inorder Traversal
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            /**
             * Find the leftmost possible position
             */
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            /**
             * Add to list
             */
            cur = stack.pop();
            list.add(cur.val);
            /**
             * Check the right subtree
             */
            cur = cur.right;
        }

        return list;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

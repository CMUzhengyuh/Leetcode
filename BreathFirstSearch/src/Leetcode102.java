import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
/**
 * Leetcode 102 - Binary Tree Level Order Traversal
 */
public class Leetcode102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            int size = stack.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = stack.removeFirst();
                level.add(cur.val);
                if (cur.left != null) stack.addLast(cur.left);
                if (cur.right != null) stack.addLast(cur.right);
            }
            list.add(level);
        }
        return list;
    }
}

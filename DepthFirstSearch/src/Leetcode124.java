public class Leetcode124 {

    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        DFS(root);
        return res;
    }

    private int DFS(TreeNode cur) {
        if (cur == null) {
            return 0;
        }
        int left = DFS(cur.left), right = DFS(cur.right);
        if (left < 0) { left = 0; }
        if (right < 0) { right = 0; }
        /**
         * Possible maximum path sum for each node:
         * (1) DFS(cur.left) + DFS(cur.right) + cur.val
         * (2) DFS(cur.left) + cur.val
         * (3) DFS(cur.right) + cur.val
         * (4) cur.val
         */
        res = Math.max(res, left + right + cur.val);
        int max = Math.max(left, right);
        /**
         * Possible maximum partial path sum for each node:
         * (1) DFS(cur.left) + cur.val
         * (2) DFS(cur.right) + cur.val
         * (3) cur.val
         */
        return (max > 0 ? max : 0) + cur.val;

    }
}

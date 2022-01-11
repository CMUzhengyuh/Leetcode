/**
 * Leetcode 1022 - Sum of Root To Leaf Binary Numbers
 */
public class Leetcode1022 {
    public int sumRootToLeaf(TreeNode root) {
        return DFS(root, 0);
    }

    private int DFS(TreeNode root, int pathSum){
        if (root == null) return 0;
        pathSum = 2 * pathSum + root.val;
        if (root.left == null && root.right == null) {
            return pathSum;
        }
        return DFS(root.left, pathSum) + DFS(root.right, pathSum);
    }
}

import java.util.HashMap;
import java.util.Map;

public class Leetcode105 {
    /**
     * HashMap to store partial root position (inorder)
     */
    Map<Integer, Integer> map;
    /**
     * Global index of preorder Array
     */
    int index;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index = 0;
        map = new HashMap<>();
        int size = inorder.length;
        for (int i = 0; i < size; ++i){
            map.put(inorder[i], i);
        }
        return DFS(preorder, 0, size - 1);
    }

    private TreeNode DFS(int[] preorder, int left, int right) {
        if (left > right) return null;
        int var = preorder[index++];
        TreeNode root = new TreeNode(var);
        int rootPos = map.get(var);
        root.left = DFS(preorder, left, rootPos - 1);
        root.right = DFS(preorder, rootPos + 1, right);
        return root;
    }

}

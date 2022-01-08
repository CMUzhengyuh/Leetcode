import java.util.HashSet;
import java.util.Set;

/**
 * Leetcode 261 - Graph Valid Tree
 */
public class Leetcode261 {
    private int[] unionFind;

    public int find(int i) {
        while (i != unionFind[i]) {
            i = unionFind[i];
        }
        return i;
    }

    public void union(int i, int j) {
        unionFind[find(j)] = find(i);
    }

    public boolean validTree(int n, int[][] edges) {
        if (n == 1) return true;
        unionFind = new int[n];
        for (int i = 0; i < n; i++) {
            unionFind[i] = i;
        }
        int root = n;
        Set<Integer> set = new HashSet<>();
        for (int[] edge : edges) {

            if (find(edge[0]) != find(edge[1])) {
                union(edge[0], edge[1]);
                root--;
            }
            set.add(edge[0]);
            set.add(edge[1]);
        }
        /**
         * Logic:
         * (1) All nodes are connected -> HashSet to record connected nodes
         * (2) #edge = #node - 1
         * (3) Only one connected component -> UnionFind to check connected component
         */
        return set.size() == n && edges.length == n - 1 && root == 1;
    }
}

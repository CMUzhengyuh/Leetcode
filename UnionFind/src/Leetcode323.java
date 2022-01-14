import java.util.Arrays;

public class Leetcode323 {

    private int[] unionFind;

    private int find(int i) {
        while (i != unionFind[i]) {
            i = unionFind[i];
        }
        return i;
    }

    private void union(int i, int j) {
        unionFind[find(j)] = find(i);
    }

    public int countComponents(int n, int[][] edges) {
        int res = n;
        unionFind = new int[n];
        for (int i = 0; i < n; i++) {
            unionFind[i] = i;
        }
        for (int[] edge : edges) {
            int i = edge[0], j = edge[1];
            if (find(i) != find(j)) {
                res--;
                union(i, j);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode323 Solution = new Leetcode323();

        int[][] test1Edges = new int[][]{{2, 3}, {1, 2}, {1, 3}};
        System.out.println(Solution.countComponents(4, test1Edges));

        int[][] test2Edges = new int[][]{{0, 1}, {1, 2}, {3, 4}};
        System.out.println(Solution.countComponents(5, test2Edges));

        int[][] test3Edges = new int[][]{{2, 3}, {1, 2}, {1, 3}, {0, 4}};
        System.out.println(Solution.countComponents(5, test3Edges));
    }
}
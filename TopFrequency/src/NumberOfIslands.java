public class NumberOfIslands {
    /**
     * Solution 1: Union Find
     * TC: O(mn)
     * SC: O(mn)
     */
    private int[] unionFind;

    private int find(int i) {
        while (i != unionFind[i]) {
            i = unionFind[i];
        }
        return i;
    }

    private void union(int i, int j) {
        unionFind[find(j)] = unionFind[find(i)];
    }

    public int numIslands(char[][] grid) {
        /**
         * Initialize the number of islands as m * n
         */
        int m = grid.length, n = grid[0].length, res = m * n;
        /**
         * Linear unionFind Array to record to the connection relationships of grid points
         * Initialize the array value as index
         */
        unionFind = new int[m * n];
        for (int k = 0; k < m * n; k++) {
            unionFind[k] = k;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                /**
                 * No land in current position
                 */
                if (grid[i][j] == '0') res--;
                else {
                    /**
                     * Check if above grid and left grid is land (could union)
                     * Once union, minus the number of islands
                     */
                    int left = i * n + j - 1, up = i * n - n + j, cur = i * n + j;
                    if (j > 0 && grid[i][j - 1] == '1' && find(cur) != find(left)) {
                        union(cur, left);
                        res--;
                    }
                    if (i > 0 && grid[i - 1][j] == '1' && find(cur) != find(up)) {
                        union(cur, up);
                        res--;
                    }
                }
            }
        }
        return res;
    }
}

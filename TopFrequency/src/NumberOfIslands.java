import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 6th - Leetcode 200 - Number of Islands
 */
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

    public int numIslandsUnionFind(char[][] grid) {
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

    /**
     * Solution 2: Depth First Search
     * TC: O(mn)
     * SC: O(mn)
     */
    private int res;

    public int numIslandsDFS(char[][] grid) {
        res = 0;
        /**
         * Loop for each position to start DFS
         */
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    DFS(grid, i, j);
                }
            }
        }
        return res;
    }

    private void DFS(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        /**
         * Convert '1' to '0' as visited
         */
        grid[i][j] = '0';
        /**
         * Four directions
         */
        DFS(grid, i + 1, j);
        DFS(grid, i - 1, j);
        DFS(grid, i, j + 1);
        DFS(grid, i, j - 1);
    }

    /**
     * Solution 3: Breadth First Search
     * TC: O(mn)
     * SC: O(mn)
     */
    private int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numIslandsBFS(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int m = grid.length, n = grid[0].length;
        res = 0;
        /**
         * Queue for BFS
         */
        Deque<Integer> deque = new ArrayDeque<>();
        /**
         * Loop for each position to start BFS
         */
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    /**
                     * Start point: unvisited '1'
                     */
                    deque.addLast(i * n + j);
                    visited[i][j] = true;
                    while (!deque.isEmpty()) {
                        int size = deque.size();
                        int index = deque.pollFirst();
                        /**
                         * Loop for current layer
                         */
                        while (size-- > 0) {
                            /**
                             * Four directions
                             */
                            for (int f = 0; f < 4; f++) {
                                int newX = (index / n) + dir[f][0], newY = (index % n) + dir[f][1];
                                if (newX >= 0 && newY >= 0 && newX < m && newY < n && !visited[newX][newY]) {
                                    visited[newX][newY] = true;
                                    if (grid[newX][newY] == '1') {
                                        deque.addLast(newX * n + newY);
                                    }
                                }
                            }
                        }
                    }
                    res++;
                }
            }
        }
        return res;
    }
}

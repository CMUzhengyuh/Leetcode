import java.util.ArrayDeque;
import java.util.Deque;
/**
 * Leetcode 200 - Number of Island
 */
public class Leetcode200 {
    /**
     * Depth First Search Solution
     */
    private int res;

    private int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numIslandsDFS(char[][] grid) {
        res = 0;
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
        grid[i][j] = '0';
        DFS(grid, i + 1, j);
        DFS(grid, i - 1, j);
        DFS(grid, i, j + 1);
        DFS(grid, i, j - 1);
    }

    /**
     * Breadth First Search Solution
     */
    public int numIslandsBFS(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int m = grid.length, n = grid[0].length;
        res = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    deque.addLast(i * n + j);
                    visited[i][j] = true;
                    while (!deque.isEmpty()) {
                        int size = deque.size();
                        int index = deque.pollFirst();
                        while (size-- > 0) {
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

    /**
     * Union Find Solution
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
        int m = grid.length, n = grid[0].length, res = m * n;
        unionFind = new int[m * n];
        for (int k = 0; k < m * n; k++) {
            unionFind[k] = k;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') res--;
                else {
                    int left = i * n + j - 1, up = i * n - n + j, cur = i * n + j;
                    if (j > 0 && grid[i][j - 1] == '1' && find(cur) != find(left)) {
                        union(cur, left);
                        res--;
                        /**
                         * DEBUG: cannot cease in current iteration here (continue)
                         * REASON: consider corner case:
                         * {'1', '1', '1'},
                         * {'1', '1', '0'},
                         * {'1', '1', '1'},
                         */
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

    public static void main(String[] args) {
        Leetcode200 Solution = new Leetcode200();

        char[][] test1Grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(Solution.numIslandsDFS(test1Grid));

        char[][] test2Grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '0', '1', '0', '1'},
                {'0', '0', '0', '1', '0'}
        };
        System.out.println(Solution.numIslandsBFS(test2Grid));

        char[][] test3Grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '0', '1', '0', '1'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(Solution.numIslandsUnionFind(test3Grid));
    }
}

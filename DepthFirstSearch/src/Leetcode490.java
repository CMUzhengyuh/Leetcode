/**
 * Leetcode 490 - The Maze
 */
public class Leetcode490 {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int rows = maze.length;
        int cols = maze[0].length;
        boolean[][] visited = new boolean[rows][cols];
        return DFS(maze, start[0], start[1], destination, visited);
    }

    private boolean DFS(int[][] maze, int row, int col, int[] destination, boolean[][] visited) {
        /**
         * Stop Condition 1: Reach the destination
         */
        if (row == destination[0] && col == destination[1]) {
            return true;
        }
        /**
         * Stop Condition 2: Visited
         */
        if (visited[row][col]) {
            return false;
        }
        visited[row][col] = true;

        return moveThenDFS(maze, row, col, destination, 1, 0, visited) ||
                moveThenDFS(maze, row, col, destination, -1, 0, visited) ||
                moveThenDFS(maze, row, col, destination, 0, 1, visited) ||
                moveThenDFS(maze, row, col, destination, 0, -1, visited);
    }

    private boolean moveThenDFS(int[][] maze, int row, int col, int[] destination, int drow, int dcol, boolean[][] visited) {
        int rows = maze.length;
        int cols = maze[0].length;
        int r = row;
        int c = col;
        while (r + drow >= 0 && r + drow <= rows - 1 && c + dcol >= 0 && c + dcol <= cols - 1 && maze[r + drow][c + dcol] == 0) {
            r = r + drow;
            c = c + dcol;
        }
        /**
         * Start from current position
         */
        return DFS(maze, r, c, destination, visited);
    }

    public static void main(String[] args) {
        Leetcode490 Solution = new Leetcode490();

        int[][] testMaze = new int[][]{{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}};
        int[] testStart = new int[]{0, 4};

        int[] test1Destination = new int[]{4, 4};
        System.out.println(Solution.hasPath(testMaze, testStart, test1Destination));

        int[] test2Destination = new int[]{3, 2};
        System.out.println(Solution.hasPath(testMaze, testStart, test2Destination));

    }
}
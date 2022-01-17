import java.util.ArrayDeque;
import java.util.Deque;
/**
 * Leetcode 302 - Smallest Rectangle Enclosing Black Pixels
 */
public class Leetcode302 {
    /**
     * BFS Solution
     */
    int[][] dir = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

    int[] res = new int[4];

    public int minAreaBFS(char[][] image, int x, int y) {
        res[0] = x;
        res[1] = x;
        res[2] = y;
        res[3] = y;
        boolean[][] visited = new boolean[image.length][image[0].length];
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.removeFirst();
                res[0] = Math.min(cur[0], res[0]);
                res[2] = Math.min(cur[1], res[2]);
                res[1] = Math.max(cur[0], res[1]);
                res[3] = Math.max(cur[1], res[3]);
                for (int j = 0; j < 4; j++) {
                    int curX = cur[0] + dir[j][0], curY = cur[1] + dir[j][1];
                    if (curX >= 0 && curX < image.length && curY >= 0 && curY < image[0].length && !visited[curX][curY] && image[curX][curY] == '1') {
                        queue.addLast(new int[]{curX, curY});
                        visited[curX][curY] = true;
                    }
                }
            }
        }
        return (res[1] - res[0] + 1) * (res[3] - res[2] + 1);
    }

    /**
     * Binary Search Solution
     */
    public int minAreaBinarySearch(char[][] image, int x, int y) {
        /**
         * Search for the boundary of rows / columns with black pixels
         */
        int leftX = 0, rightX = 0, leftY = 0, rightY = 0;
        /**
         * Leftmost column
         */
        int left = 0, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            boolean hasBlackPixel = false;
            for (int j = 0; j < image[0].length; j++) {
                hasBlackPixel |= image[mid][j] == '1';
            }
            if (hasBlackPixel) {
                leftX = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        /**
        * Rightmost column
        */
        left = x;
        right = image.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            boolean hasBlackPixel = false;
            for (int j = 0; j < image[0].length; j++) {
                hasBlackPixel |= image[mid][j] == '1';
            }
            if (hasBlackPixel) {
                rightX = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        /**
         * Leftmost row
         */
        left = 0;
        right = y;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            boolean hasBlackPixel = false;
            for (int i = 0; i < image.length; i++) {
                hasBlackPixel |= image[i][mid] == '1';
            }
            if (hasBlackPixel) {
                leftY = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        /**
         * Rightmost row
         */
        left = y;
        right = image[0].length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            boolean hasBlackPixel = false;
            for (int i = 0; i < image.length; i++) {
                hasBlackPixel |= image[i][mid] == '1';
            }
            if (hasBlackPixel) {
                rightY = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return (rightX - leftX + 1) * (rightY - leftY + 1);

    }

    public static void main(String[] args) {
        Leetcode302 Solution = new Leetcode302();

        char[][] test1Image = new char[][]{{'0', '0', '1', '0'}, {'0', '1', '1', '0'},{'0', '1', '0', '0'}};
        System.out.println(Solution.minAreaBFS(test1Image, 0, 2));

        char[][] test2Image = new char[][]{{'0', '1', '0'}};
        System.out.println(Solution.minAreaBinarySearch(test1Image, 0, 2));


    }
}

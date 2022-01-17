/**
 * Leetcode 74 - Search a 2D Matrix ***
 */
public class Leetcode74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        /**
         * Start from the top right element
         * OPTIONAL: bottom left element
         */
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                /**
                 * Traverse left
                 */
                j--;
            } else {
                /**
                 * Traverse Down
                 */
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Leetcode74 Solution = new Leetcode74();

        int[][] testMatrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(Solution.searchMatrix(testMatrix, 0));

        System.out.println(Solution.searchMatrix(testMatrix, 13));

        System.out.println(Solution.searchMatrix(testMatrix, 30));

        System.out.println(Solution.searchMatrix(testMatrix, 60));

        System.out.println(Solution.searchMatrix(testMatrix, 100));

    }
}
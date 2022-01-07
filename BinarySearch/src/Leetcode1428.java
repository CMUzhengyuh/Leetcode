import java.util.ArrayList;
import java.util.List;


public class Leetcode1428 {
    /**
     * // This is the BinaryMatrix's API interface.
     * // You should not implement it, or speculate about its implementation
     * interface BinaryMatrix {
     *     public int get(int row, int col) {}
     *     public List<Integer> dimensions {}
     * };
     */

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int rows = binaryMatrix.dimensions().get(0);
        int cols = binaryMatrix.dimensions().get(1);
        int index = cols;
        for (int i = 0; i < rows; i++){
            int start = 0;
            int end = index - 1;
            if (index == 0){
                return index;
            }
            if (binaryMatrix.get(i, end) == 0){
                continue;
            }
            while (start < end){
                int mid = (start + end) / 2;
                if (binaryMatrix.get(i, mid) == 0){
                    start = mid + 1;
                } else {
                    end = mid;
                }
                if (binaryMatrix.get(i, start) == 1){
                    index = Math.min(index, start);
                }
            }
        }
        return index == cols ? -1 : index;
    }

    private static class BinaryMatrix {
        private int[][] binaryMatrix;

        public BinaryMatrix(int[][] martix) {
            binaryMatrix = martix;
        }

        public List<Integer> dimensions() {
            List<Integer> res = new ArrayList<>();
            res.add(binaryMatrix.length);
            res.add(binaryMatrix[0].length);
            return res;
        }

        public int get(int row, int col) {
            return binaryMatrix[row][col];
        }
    }

    public static void main(String[] args) {
        Leetcode1428 Solution = new Leetcode1428();

        BinaryMatrix test1BinaryMatrix = new BinaryMatrix(new int[][]{{0, 0}, {1, 1}});
        System.out.println(Solution.leftMostColumnWithOne(test1BinaryMatrix));

        BinaryMatrix test2BinaryMatrix = new BinaryMatrix(new int[][]{{0, 0}, {0, 1}});
        System.out.println(Solution.leftMostColumnWithOne(test2BinaryMatrix));

        BinaryMatrix test3BinaryMatrix = new BinaryMatrix(new int[][]{{0, 0}, {0, 0}});
        System.out.println(Solution.leftMostColumnWithOne(test3BinaryMatrix));
    }
}


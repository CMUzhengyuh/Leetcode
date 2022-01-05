import java.lang.module.ResolutionException;

/**
 * Leetcode 702 - Search in a Sorted Array of Unknown Size
 */
public class Leetcode702 {
    /**
     * // This is ArrayReader's API interface.
     * // You should not implement it, or speculate about its implementation
     * interface ArrayReader {
     *     public int get(int index) {}
     * }
     */
    public int search(ArrayReader reader, int target) {
        int right = 1;
        while (reader.get(right) < target) {
            right = right << 1;
        }
        int left = right >> 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (reader.get(mid) > target) {
                right = mid - 1;
            } else if (reader.get(mid) < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private static class ArrayReader {
        private int[] arr;

        public ArrayReader(int[] nums) {
            arr = nums;
        }

        public int get(int index) {
            if (index < arr.length) return arr[index];
            else return Integer.MAX_VALUE;
        }
    }

    public static void main(String[] args) {
        Leetcode702 Solution = new Leetcode702();

        int[] test1Nums = new int[] {2, 4, 5, 7, 8, 10};
        System.out.println(Solution.search(new ArrayReader(test1Nums), 8));
        System.out.println(Solution.search(new ArrayReader(test1Nums), 9));

        int[] test2Nums = new int[] {0};
        System.out.println(Solution.search(new ArrayReader(test2Nums), 0));
        System.out.println(Solution.search(new ArrayReader(test2Nums), -1));
    }
}

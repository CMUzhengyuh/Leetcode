/**
 * Leetcode 852 - Peak Index in a Mountain Array
 */
public class Leetcode852 {
    public int peakIndexInMountainArray(int[] arr) {
        /**
         * Template of binary search with edge case
         */
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else right = mid;
        }
        return left;
    }

    public static void main(String[] args) {
        Leetcode852 Solution = new Leetcode852();

        int[] test1Array = new int[]{0, 2, 4, 5, 3, 1};
        System.out.println(Solution.peakIndexInMountainArray(test1Array));

        int[] test2Array = new int[]{0, 10, 5, 2};
        System.out.println(Solution.peakIndexInMountainArray(test1Array));
    }
}
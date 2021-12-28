import java.util.Arrays;
/**
 * Leetcode 34 - Find First and Last Position of Element in Sorted Array
 */
public class Leetcode34 {
    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int left = 0, right = nums.length - 1, mid = -1;
        /**
         * Find left boundary
         */
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                res[0] = mid;
            }
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                /**
                 * Even if <target == num[mid]>, try to find the leftmost position
                 */
                right = mid - 1;
            }
        }
        left = 0;
        right = nums.length - 1;
        /**
         * Find right boundary
         */
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                res[1] = mid;
            }
            if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test1Nums = new int[] {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(searchRange(test1Nums, 7)));
        System.out.println(Arrays.toString(searchRange(test1Nums, 8)));

        int[] test2Nums = new int[] {0};
        System.out.println(Arrays.toString(searchRange(test2Nums, 0)));

    }
}

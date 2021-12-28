/**
 * Leetcode 704 - Binary Search
 */
public class Leetcode704 {
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] test1Nums = new int[] {-1, 0, 3, 5, 9, 12};
        System.out.println(search(test1Nums, 9));

        int[] test2Nums = new int[] {0};
        System.out.println(search(test2Nums, 0));

    }
}

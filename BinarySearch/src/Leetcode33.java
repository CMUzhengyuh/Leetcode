/**
 * Leetcode 33 - Search in Rotated Sorted Array
 */
public class Leetcode33 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            if ( (nums[mid] < target && nums[mid] < nums[right] && nums[right] >= target) ||
                    (nums[mid] >= nums[left] && nums[mid] > nums[right] && (nums[mid] < target ||
                            nums[right] >= target)) ) {
                left = mid + 1;
            } else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Leetcode33 Solution = new Leetcode33();

        int[] test1Nums = new int[] {4, 5, 6, 7, 8, 9, 0, 1, 2, 3};
        System.out.println(Solution.search(test1Nums, 0));

        int[] test2Nums = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Solution.search(test2Nums, 9));

    }
}

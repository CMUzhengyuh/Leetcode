/**
 * Leetcode 81 - Search in Rotated Sorted Array II
 */
public class Leetcode81 {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return true;
            /**
             * The difference between Leetcode 33 & 81 - skip duplicates
             */
            while (nums[left] == nums[mid] && left != mid) {left++;}
            while (nums[right] == nums[mid] && right != mid) {right--;}
            if ( (nums[mid] < target && nums[mid] < nums[right] && nums[right] >= target) ||
                    (nums[mid] >= nums[left] && nums[mid] > nums[right] && (nums[mid] < target ||
                            nums[right] >= target)) ) {
                left = mid + 1;
            } else right = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        Leetcode81 Solution = new Leetcode81();

        int[] test1Nums = new int[] {2, 5, 6, 0, 0, 1, 2};
        System.out.println(Solution.search(test1Nums, 0));

        int[] test2Nums = new int[] {1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1};
        System.out.println(Solution.search(test2Nums, 2));

    }
}

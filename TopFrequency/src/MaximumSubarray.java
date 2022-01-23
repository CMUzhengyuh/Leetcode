/**
 * 15th - Leetcode 53 - Maximum Subarray
 */
public class MaximumSubarray {
    /**
     * Solution: Dynamic Programming
     * TC: O(n)
     * SC: O(1)
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        int max = nums[0];
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++){
            /**
             * Positive number - could make sum bigger
             */
            if (prev > 0) {
                prev =  prev + nums[i];
            }
            /**
             * Negative number - restart
             */
            else {
                prev = nums[i];
            }
            max = Math.max(max, prev);
        }
        return max;
    }
}

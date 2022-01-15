/**
 * Leetcode 209 - Minimum Size Subarray Sum
 */
public class Leetcode209 {
    public int minSubArrayLen(int target, int[] nums) {
        int res = nums.length + 1, left = 0, right = 0, cur = 0;
        for (right = 0; right < nums.length; right++) {
            cur += nums[right];
            if (cur >= target) {
                while (cur >= target + nums[left]) {
                    cur -= nums[left++];
                }
                res = Math.min(res, right - left + 1);
            }
        }
        return res == nums.length + 1 ? 0 : res;
    }

    public static void main(String[] args) {
        Leetcode209 Solution = new Leetcode209();

        int[] test1Nums = new int[]{2, 3, 1, 2, 4, 3};
        System.out.println(Solution.minSubArrayLen(7, test1Nums));

        int[] test2Nums = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 4};
        System.out.println(Solution.minSubArrayLen(15, test2Nums));
    }
}
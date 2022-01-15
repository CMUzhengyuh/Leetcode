/**
 * Leetcode 713 - Subarray Product Less Than K
 */
public class Leetcode713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int left = 0, right = 0, res = 0, prod = 1;
        for (right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k && left <= right) {
                prod /= nums[left++];
            }
            res += (right - left + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode713 Solution = new Leetcode713();

        int[] test1Nums = new int[]{10, 5, 2, 6};
        System.out.println(Solution.numSubarrayProductLessThanK(test1Nums, 1000));

        System.out.println(Solution.numSubarrayProductLessThanK(test1Nums, 100));

        System.out.println(Solution.numSubarrayProductLessThanK(test1Nums, 50));

        System.out.println(Solution.numSubarrayProductLessThanK(test1Nums, 12));

        System.out.println(Solution.numSubarrayProductLessThanK(test1Nums, 10));

        System.out.println(Solution.numSubarrayProductLessThanK(test1Nums, 5));

        System.out.println(Solution.numSubarrayProductLessThanK(test1Nums, 2));
    }
}

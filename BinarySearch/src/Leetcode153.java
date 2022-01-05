/**
 * Leetcode 153 - Find Minimum in Rotated Sorted Array
 */
public class Leetcode153 {
    public int findMin(int[] nums) {
        /**
         * Check the validation
         */
        if (nums == null || nums.length == 0) return -1;
        /**
         * Check if the rotation point index is 0
         */
        int len = nums.length;
        if (nums.length == 1 || nums[0] < nums[len - 1]) return nums[0];

        int left = 0, right = len - 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            /**
             * {
             *     <[0, rotationPoint]>                has value less than <nums[0]>
             *     <[rotationPoint, nums.length - 1]>  has value greater than <nums[0]>
             * }
             * --> <mid> is to the left of rotation point
             */
            if (nums[mid] >= nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        Leetcode153 Solution = new Leetcode153();

        int[] test1Nums = new int[] {4, 5, 6, 7, 8, 9, 0, 1, 2, 3};
        System.out.println(Solution.findMin(test1Nums));

        int[] test2Nums = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Solution.findMin(test2Nums));

    }
}

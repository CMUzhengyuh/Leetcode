/**
 * 7th - Leetcode 4 - Median of Two Sorted Arrays ***
 */
public class MedianOfTwoSortedArrays {
    /**
     * Solution 1: Two Pointers
     * TC: O(m + n)
     * SC: O(1)
     */
    public double findMedianSortedArraysTwoPointers(int[] nums1, int[] nums2) {
        int p1 = 0, p2 = 0;
        int midLeft = 0, midRight = 0;
        for (int i = 0; i <= (nums1.length + nums2.length) / 2; i++) {
            midLeft = midRight;
            /**
             * One pointer reach the end
             */
            if (p1 == nums1.length) {
                midRight = nums2[p2++];
            } else if (p2 == nums2.length) {
                midRight = nums1[p1++];
            }
            /**
             * The pointer with smaller value moves forward
             */
            else if (nums1[p1] < nums2[p2] ) {
                midRight = nums1[p1++];
            } else {
                midRight = nums2[p2++];
            }
        }
        /**
         * Even number of elements
         */
        if ((nums1.length + nums2.length) % 2 == 0) {
            return (double)(midLeft + midRight) / 2;
        }
        return midRight;
    }

    /**
     * Solution 2: Binary Search
     * TC: O(log(m + n))
     * SC: O(1)
     */
    public double findMedianSortedArraysBinarySearch(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        /**
         * Numbers of elements to reach the right median
         */
        int k = (m + n) / 2, p1, p2;
        /**
         * Left and right pointer in nums1
         */
        int left = 0, right = Math.min(k, m);
        /**
         * Binary Search
         */
        while (true) {
            /**
             * p1 points to the middle position in nums1
             */
            p1 = left + (right - left) / 2;
            /**
             * p2 points to the position in nums2 so that p1 + p2 = k
             */
            p2 = k - p1;
            if (getIfExist(nums1, p1) >= getIfExist(nums2, p2 - 1)) {
                /**
                 * nums1[p1 - 1] <= nums2[p2] && nums2[p2 - 1] <= nums1[p1] -> p1 & p2 should stop
                 */
                if (getIfExist(nums2, p2) >= getIfExist(nums1, p1 - 1))
                    break;
                else right = p1 - 1;
            }
            else left = p1 + 1;
        }
        if ((m + n) % 2 == 1)
            return Math.min(getIfExist(nums1, p1), getIfExist(nums2, p2));
        /**
         * Even number of elements
         */
        return (double)(Math.min(getIfExist(nums1, p1), getIfExist(nums2, p2)) +
                        Math.max(getIfExist(nums1, p1 - 1), getIfExist(nums2,p2 - 1))) / 2;
    }
    /**
     * If index is valid return the value
     */
    private int getIfExist(int[] nums, int i) {
        if (i < 0)
            return Integer.MIN_VALUE;
        if (i >= nums.length)
            return Integer.MAX_VALUE;
        return nums[i];
    }
}

/**
 * 7th - Leetcode 4 - Median of Two Sorted Arrays
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
         * midLeft = midRight when m + n % 2 == 1
         */
        int midLeft = (m + n + 1) / 2, midRight = (m + n + 2) / 2;
        return (getKthElement(nums1, 0, nums2, 0, midLeft) +
                getKthElement(nums1, 0, nums2, 0, midRight)) / 2.0;
    }

    public double getKthElement(int[] nums1, int a, int[] nums2, int b, int k) {
        /**
         * One pointer reach the end
         */
        if (a > nums1.length - 1) return nums2[b + k - 1];
        if (b > nums2.length - 1) return nums1[a + k - 1];
        if (k == 1) return Math.min(nums1[a], nums2[b]);

        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
        if (a + k / 2 - 1 < nums1.length) aMid = nums1[a + k / 2 - 1];
        if (b + k / 2 - 1 < nums2.length) bMid = nums2[b + k / 2 - 1];

        if (aMid < bMid)
            return getKthElement(nums1, a + k / 2, nums2, b, k - k / 2);
        else
            return getKthElement(nums1, a, nums2, b + k / 2, k - k / 2);
    }
}

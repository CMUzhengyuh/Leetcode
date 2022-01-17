/**
 * Leetcode 162 - Find Peak Element
 */
public class Leetcode162 {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Leetcode162 Solution = new Leetcode162();

        int[] test1Nums = new int[] {4, 5, 6, 7, 8, 9, 0, 1, 2, 3};
        System.out.println(Solution.findPeakElement(test1Nums));

        int[] test2Nums = new int[] {1, 2, 1, 3, 5, 6, 4};
        System.out.println(Solution.findPeakElement(test2Nums));

    }
}



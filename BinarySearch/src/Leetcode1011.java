/**
 * Leetcode 1011 - Capacity To Ship Packages Within D Days
 */
public class Leetcode1011 {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;
        for (int weight : weights) {
            /**
             * The minimum capacity is the largest weight while the maximum is the sum of weights
             */
            right += weight;
            left = Math.max(left, weight);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            /**
             * The amount of packages must be initialized as 1 in that at least 1 package is needed
             */
            int count = 1, size = 0;
            for (int weight : weights) {
                if (size + weight > mid) {
                    count++;
                    size = weight;
                } else {
                    size += weight;
                }
            }
            if (count <= days) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Leetcode1011 Solution = new Leetcode1011();

        int[] test1Nums = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Solution.shipWithinDays(test1Nums, 5));
        System.out.println(Solution.shipWithinDays(test1Nums, 6));
        System.out.println(Solution.shipWithinDays(test1Nums, 8));


        int[] test2Nums = new int[] {1, 2, 3, 10};
        System.out.println(Solution.shipWithinDays(test2Nums, 2));

    }
}

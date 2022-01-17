/**
 * Leetcode 875 - Koko Eating Bananas
 */
public class Leetcode875 {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0;
        for (int i : piles) {
            right = Math.max(right, i);
        }
        while (left < right) {
            int mid = left + (right - left) / 2, times = 0;
            for (int i : piles) {
                /**
                 * Calculate ceiling(i / mid)
                 */
                times += (i + mid - 1) / mid;
            }
            if (times > h) {
                left = mid + 1;
            } else right = mid;
        }
        return left;
    }

    public static void main(String[] args) {
        Leetcode875 Solution = new Leetcode875();

        int[] test1Piles = new int[]{3, 6, 7, 11};

        System.out.println(Solution.minEatingSpeed(test1Piles, 30));

        System.out.println(Solution.minEatingSpeed(test1Piles, 15));

        System.out.println(Solution.minEatingSpeed(test1Piles, 8));

        System.out.println(Solution.minEatingSpeed(test1Piles, 5));

        System.out.println(Solution.minEatingSpeed(test1Piles, 4));

    }
}



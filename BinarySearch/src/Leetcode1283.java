public class Leetcode1283 {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1, right = (int)1e6, result = 0, mid = 0;
        for (int num : nums) {
            right = Math.max(num, right);
        }
        while (left < right) {
            mid = left + (right - left) / 2;
            result = 0;
            for (int num : nums) {
                result += (num + mid - 1) / mid;
            }
            if (result > threshold) {
                left = mid + 1;
            } else right = mid;
        }
        return left;
    }

    public static void main(String[] args) {
        Leetcode1283 Solution = new Leetcode1283();

        int[] test1Piles = new int[]{3, 6, 7, 11};

        System.out.println(Solution.smallestDivisor(test1Piles, 5));

    }
}

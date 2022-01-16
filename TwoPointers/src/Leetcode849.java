/**
 * Leetcode 849 - Maximize Distance to Closest Person
 */
public class Leetcode849 {
    public int maxDistToClosest(int[] seats) {
        int left = 0, right = 0, res = 0;
        while (right < seats.length) {
            while (right < seats.length - 1 && seats[right] == 0) {
                right++;
            }
            if ((seats[left] == 0 && left == 0) || (seats[right] == 0 && right == seats.length - 1)) {
                res = Math.max(right - left, res);
            } else {
                res = Math.max((right - left) / 2, res);
            }
            left = right++;
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode849 Solution = new Leetcode849();

        int[] test1Array = new int[]{1, 0, 0, 0, 1, 0, 1};
        System.out.println(Solution.maxDistToClosest(test1Array));

        int[] test2Array = new int[]{1, 0, 0, 0};
        System.out.println(Solution.maxDistToClosest(test2Array));
    }
}

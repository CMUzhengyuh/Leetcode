/**
 * Leetcode 11 - Container With Most Water
 */
public class Leetcode11 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int res = 0;
        while (left < right) {
            int edge = Math.min(height[left], height[right]);
            res = Math.max(res, edge * (right - left));
            if (height[left] == edge) {
                while (left < right && height[left] <= edge) {
                    left++;
                }
            } else {
                while (left < right && height[right] <= edge) {
                    right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode11 Solution = new Leetcode11();

        int[] test1Array = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(Solution.maxArea(test1Array));

        int[] test2Array = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 4};
        System.out.println(Solution.maxArea(test2Array));
    }
}

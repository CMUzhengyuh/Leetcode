import java.util.Stack;
/**
 * 3rd - Leetcode 42 - Trapping Rain Water
 * Example:
 *
 *   5                       *
 *   4   *   @   @   @   @   *
 *   3   *   @   @   *   @   *
 *   2   *   *   @   *   *   *
 *   1   *   *   @   *   *   *
 *       0   1   2   3   4   5
 */
public class TrappingRainWater {
    /**
     * Solution 1: Monotonic Stack
     * TC: O(n)
     * SC: O(n)
     */
    public int trapMonotonicStack(int[] height) {
        /**
         * Monotonic decreasing stack
         */
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            /**
             * Maintain the decreasing sequence of stack elements
             */
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                /**
                 * Possible bottom height of rain water
                 */
                int bottom = height[stack.pop()];
                /**
                 * Check if can trap water
                 */
                if (!stack.isEmpty()) {
                    /**
                     * The height of rain water = min(leftBound, rightBound) - bottom
                     * LeftBound height comes from the top element of stack
                     * RightBound height comes from the newest element in traversal
                     *
                     * The width of rain water = right - left - 1
                     */
                    res += (Math.min(height[i], height[stack.peek()]) - bottom) * (i - stack.peek() - 1);
                }
            }
            stack.push(i);
        }
        return res;
    }

    /**
     * Solution 2: Dynamic Programming
     * TC: O(n)
     * SC: O(n)
     */
    public int trapDynamicProgramming(int[] height) {
        /**
         * Less than 3 columns cannot trap water
         */
        if (height.length < 3) return 0;
        int res = 0, water;
        /**
         * Arrays of left maximum height and right maximum height from the view in current position
         */
        int[] leftMax = new int[height.length], rightMax = new int[height.length];
        /**
         * First loop to calculate left maximum
         */
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }
        /**
         * Second loop to calculate right maximum then trapping water in current position
         */

        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
            water = Math.min(rightMax[i], leftMax[i]) - height[i];
            res += water > 0 ? water : 0;
        }
        return res;
    }

    /**
     * Solution 3: Two Pointers
     * TC: O(n)
     * SC: O(1)
     */
    public int trapTwoPointers(int[] height) {
        if (height.length < 3) return 0;
        int leftMax = height[0], rightMax = height[height.length - 1];
        int left = 1, right = height.length - 2, ans = 0;
        while (left <= right) {
            /**
             * LeftBound is lower than rightBound
             */
            if (leftMax < rightMax) {
                /**
                 * left pointer contribute to higher left bound
                 */
                if (height[left] > leftMax)
                    leftMax = height[left];
                /**
                 * height[left] <= leftMax < rightMax
                 * We cannot predict a precise rightMax for index = left but leftMax is accurate
                 * Index = left can trap water with height = leftMax - height[left]
                 */
                else
                    ans += leftMax - height[left];
                left++;
            }
            /**
             * RightBound is lower than leftBound
             */
            else {
                /**
                 * right pointer contribute to higher right bound
                 */
                if (height[right] > rightMax)
                    rightMax = height[right];
                /**
                 * height[right] <= rightMax < leftMax
                 * We cannot predict a precise leftMax for index = right but rightMax is accurate
                 * Index = left can trap water with height = rightMax - height[right]
                 */
                else
                    ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
    }
}

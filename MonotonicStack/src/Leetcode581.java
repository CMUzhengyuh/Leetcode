import java.util.Stack;

/**
 * Leetcode 581 - Shortest Unsorted Continuous Sub-array
 */
public class Leetcode581 {
    public int findUnsortedSubarray(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int min = nums.length - 1, max = 0, maxVal = -10000;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                /**
                 * The minimum index of the sub-array
                 */
                min = Math.min(min, stack.peek());
                /**
                 * The maximum value in the sub-array
                 */
                maxVal = Math.max(maxVal, nums[stack.pop()]);
            }
            stack.push(i);
            if (i > min && nums[i] < maxVal) {
                /**
                 * Check if the new value locate in the range of sub-array
                 */
                max = Math.max(max, i);
            }
        }
        return max == 0 ? 0 : max - min + 1;
    }

    public static void main(String[] args) {
        Leetcode581 Solution = new Leetcode581();

        int[] test1Nums = new int[]{2, 3, 3, 2, 4};
        System.out.println(Solution.findUnsortedSubarray(test1Nums));

        int[] test2Nums = new int[]{1, 3, 2, 2, 2};
        System.out.println(Solution.findUnsortedSubarray(test2Nums));

        int[] test3Nums = new int[]{1, 3, 3, 3, 2};
        System.out.println(Solution.findUnsortedSubarray(test3Nums));
    }
}
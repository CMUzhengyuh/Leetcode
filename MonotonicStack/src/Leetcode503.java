import java.util.Arrays;
import java.util.Stack;
/**
 * Leetcode 503 - Next Greater Element II
 */
public class Leetcode503 {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(res, -1);
        /**
         * Loop twice to get in circular result
         */
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                res[stack.pop()] = nums[i];
            }
            stack.push(i);
        }
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                res[stack.pop()] = nums[i];
            }
            /**
             * Do not need to push Stack in the second iteration
             */
        }
        return res;
    }
    public static void main(String[] args) {
        Leetcode503 Solution = new Leetcode503();

        int[] test1Nums = new int[]{1, 2, 3, 1};
        System.out.println(Arrays.toString(Solution.nextGreaterElements(test1Nums)));

        int[] test2Nums = new int[]{2, 4, 5, 2, 1};
        System.out.println(Arrays.toString(Solution.nextGreaterElements(test2Nums)));
    }
}

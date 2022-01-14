import java.util.Arrays;
import java.util.Stack;
/**
 * Leetcode 739 - Daily Temperatures
 */
public class Leetcode739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = res.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode739 Solution = new Leetcode739();

        int[] test1Temperatures = new int[]{89, 62, 70, 58, 47, 47, 46, 76, 100, 70};
        System.out.println(Arrays.toString(Solution.dailyTemperatures(test1Temperatures)));

        int[] test2Temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(Solution.dailyTemperatures(test2Temperatures)));
    }
}

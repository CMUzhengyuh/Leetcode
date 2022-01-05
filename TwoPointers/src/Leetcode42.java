import java.util.Stack;
/**
 * Leetcode 42 - Trapping Rain Water
 */
public class Leetcode42 {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int begin = 0, result = 0;
        for (int i = begin; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int valley = height[stack.pop()];
                if (!stack.isEmpty())
                    result += (Math.min(height[i], height[stack.peek()]) - valley) * (i - stack.peek() - 1);
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Leetcode42 Solution = new Leetcode42();

        int[] test1Array = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(Solution.trap(test1Array));

        int[] test2Array = new int[]{4, 2, 0, 3, 2, 5};
        System.out.println(Solution.trap(test2Array));
    }
}

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/**
 * Leetcode 496 - Next Greater Element I
 */
public class Leetcode496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        /**
         * Monotonic Decreasing Stack
         */
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[nums1.length];
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        int index = 0;
        for (int num : nums1) {
            res[index++] = map.getOrDefault(num, -1);
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode496 Solution = new Leetcode496();

        int[] test1Nums1 = new int[]{4, 1, 2}, test1Nums2 = new int[]{1, 3, 4, 2};
        System.out.println(Arrays.toString(Solution.nextGreaterElement(test1Nums1, test1Nums2)));

        int[] test2Nums1 = new int[]{2, 4, 5}, test2Nums2 = new int[]{2, 4, 5, 3, 1};
        System.out.println(Arrays.toString(Solution.nextGreaterElement(test2Nums1, test2Nums2)));
    }
}

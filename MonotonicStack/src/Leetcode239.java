import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
/**
 * Leetcode 239 - Sliding Window Maximum
 */
public class Leetcode239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int l = nums.length, index = 0;
        int[] res = new int[l - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < l; i++) {
            if (i >= k) {
                res[index++] = deque.peekFirst();
                if (nums[i - k] == deque.peekFirst()) {
                    deque.removeFirst();
                }
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        res[index] = deque.peekFirst();
        return res;
    }

    public static void main(String[] args) {
        Leetcode239 Solution = new Leetcode239();

        int[] test1Nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(Solution.maxSlidingWindow(test1Nums, 3)));

        int[] test2Nums = new int[]{1, 3, -1, -3, 5, 3, 6, 4};
        System.out.println(Arrays.toString(Solution.maxSlidingWindow(test2Nums, 4)));
    }
}

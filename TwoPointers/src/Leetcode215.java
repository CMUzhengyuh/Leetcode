import java.util.Arrays;
import java.util.PriorityQueue;
/**
 * Leetcode 215 - K-th Largest Element in an Array
 */
public class Leetcode215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        Leetcode215 Solution = new Leetcode215();

        int[] test1Array = new int[]{0, 0, 2, 1, 3, 0, 3, 4, 1, 5, 0, 5};
        System.out.println(Solution.findKthLargest(test1Array, 8));

        int[] test2Array = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(Solution.findKthLargest(test2Array, 4));
    }
}

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
/**
 * Leetcode 480 - Sliding Window Median
 */
public class Leetcode480 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int l = nums.length, index = 0;
        double[] res = new double[l - k + 1];
        if (k == 1) {
            for (int i = 0; i < l; i++) {
                res[i] = nums[i] * 1.0;
            }
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder()), maxHeap = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }
        for (int j = 0; j < k / 2; j++) {
            maxHeap.add(minHeap.poll());
        }
        for (int i = k; i < l; i++) {
            double median = k % 2 == 0 ? ((double)minHeap.peek() + maxHeap.peek()) / 2.0 : minHeap.peek();
            res[index++] = median;
            if (minHeap.size() > 0 && nums[i - k] <= minHeap.peek()) {
                minHeap.remove(nums[i - k]);
            } else maxHeap.remove(nums[i - k]);
            if (minHeap.size() > 0 && nums[i] <= minHeap.peek()) {
                minHeap.add(nums[i]);
            } else maxHeap.add(nums[i]);
            if (minHeap.size() >= maxHeap.size() + 2) {
                maxHeap.add(minHeap.poll());
            }
            if (maxHeap.size() > minHeap.size()) {
                minHeap.add(maxHeap.poll());
            }
        }
        double median = k % 2 == 0 ? ((double)minHeap.peek() + maxHeap.peek()) / 2.0 : minHeap.peek();
        res[index++] = median;
        return res;
    }

    public static void main(String[] args) {
        Leetcode480 Solution = new Leetcode480();

        int[] test1Array = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(Solution.medianSlidingWindow(test1Array, 3)));

        int[] test2Array = new int[]{2147483647, 1, 2, 3, 4, 5, 6, 7, 2147483647};
        System.out.println(Arrays.toString(Solution.medianSlidingWindow(test2Array, 2)));
    }
}
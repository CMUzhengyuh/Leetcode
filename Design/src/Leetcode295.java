import java.util.Collections;
import java.util.PriorityQueue;
/**
 * Leetcode 295 - Find Median from Data Stream
 */
public class Leetcode295 {
    private PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> large = new PriorityQueue<>();
    private boolean even = true;

    public double findMedian() {
        if (even)
            return (small.peek() + large.peek()) / 2.0;
        else
            return small.peek();
    }

    public void addNum(int num) {
        if (even) {
            large.offer(num);
            small.offer(large.poll());
        } else {
            small.offer(num);
            large.offer(small.poll());
        }
        even = !even;
    }

    public static void main(String[] args) {
        Leetcode295 Solution = new Leetcode295();

        Solution.addNum(1);
        Solution.addNum(2);
        System.out.println(Solution.findMedian());
        Solution.addNum(3);
        System.out.println(Solution.findMedian());
    }
}

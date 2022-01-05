import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
/**
 * Leetcode 969 - Pancake Sorting
 */
public class Leetcode969 {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> list = new ArrayList<>();
        /**
         * Heap to sort the index with descending value order
         */
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> arr[b] - arr[a]);
        for (int i = 0; i < arr.length; i++) {
            pq.add(i);
        }
        /**
         * For any target number at K and final position at N:
         * (1) Flip K: K -> 0
         * (2) Flip N: 0 -> N
         */
        while (!pq.isEmpty()) {
            /**
             * Target maximum number currently
             */
            int cur = pq.poll();
            /**
             * Calculate current position of target number
             */
            for (int i : list) {
                if (cur < i) {
                    cur = i - 1 - cur;
                }
            }
            /**
             * Two corner case:
             * A. <cur == pq.size()> - target number has been in the right position
             * B. <cur == 0> - target number has been in the first place
             */
            if (cur != pq.size()) {
                if (cur != 0) {
                    list.add(cur + 1);
                }
                list.add(pq.size() + 1);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Leetcode969 Solution = new Leetcode969();

        int[] test1Array = new int[]{4, 5, 1, 3, 2};
        System.out.println(Solution.pancakeSort(test1Array).toString());
    }
}

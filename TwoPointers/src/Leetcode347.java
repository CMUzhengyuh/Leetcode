import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
/**
 * Leetcode 347 - Top K-Frequent Elements
 */
public class Leetcode347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for (Integer key : map.keySet()) {
            pq.add(new int[]{key, map.get(key)});
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll()[0];
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode347 Solution = new Leetcode347();

        int[] test1Array = new int[]{1, 1, 1, 2, 2, 3, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 6, 7};
        System.out.println(Arrays.toString(Solution.topKFrequent(test1Array, 7)));

        int[] test2Array = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(Arrays.toString(Solution.topKFrequent(test2Array, 6)));
    }
}

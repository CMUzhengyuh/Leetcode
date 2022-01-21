import java.util.HashMap;
import java.util.Map;
/**
 * 13th - Leetcode 560 - Subarray Sum Equals K
 */
public class SubarraySumEqualsK {
    /**
     * Solution: Prefix Sum & HashTable
     * TC: O(n)
     * SC: O(n)
     */
    public int subarraySum(int[] nums, int k) {
        /**
         * HashMap to store the prefix and corresponding frequency
         */
        Map<Integer, Integer> map = new HashMap<>();
        /**
         * Prefix of no elements
         */
        map.put(0, 1);
        int prefix = 0, res = 0;
        for (int num : nums) {
            prefix += num;
            /**
             * k = prefix[m] - prefix[n] (n < m)
             */
            res += map.getOrDefault(prefix - k, 0);
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }
        return res;
    }
}

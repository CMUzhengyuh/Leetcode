import java.util.HashMap;
/**
 * 1st - Leetcode 1 - Two Sum
 */
public class TwoSum {
    /**
     * Solution: HashTable
     * TC: O(n)
     * SC: O(n)
     */
    public int[] twoSum(int[] nums, int target) {
        /**
         * HashMap - Key: numbers in srcArray / Value: index
         */
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            /**
             * Check if existed in HashMap
             */
            if (map.containsKey(target - nums[i]))
                return new int[] {map.get(target - nums[i]), i};
            else map.put(nums[i], i);
        }
        return null;
    }
}

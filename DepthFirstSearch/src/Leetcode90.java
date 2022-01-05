import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Leetcode 90 - Subsets II
 */
public class Leetcode90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<List<Integer>> res;
        res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == 0) {
                continue;
            }
            int size = res.size();
            for (int j = 0; j < size; j++) {
                List<Integer> list = res.get(j);
                List<Integer> newList = new ArrayList<>(list);
                for (int k = 0; k < map.get(nums[i]); k++) {
                    newList.add(nums[i]);
                    res.add(new ArrayList<>(newList));
                }
            }
            map.put(nums[i], 0);
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode90 Solution = new Leetcode90();

        int[] test1Array = new int[]{1, 1, 2};
        System.out.println(Solution.subsetsWithDup(test1Array).toString());

        int[] test2Array = new int[]{1, 2, 2, 3, 3, 3};
        System.out.println(Solution.subsetsWithDup(test2Array).toString());

    }
}

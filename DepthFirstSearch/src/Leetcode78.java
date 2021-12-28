import java.util.ArrayList;
import java.util.List;
/**
 * Leetcode 78 - Subsets
 */
public class Leetcode78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res;
        res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            /**
             * DEBUG: Concurrent Modification Exception
             * REASON: Add new list to the result
             */
            int size = res.size();
            for (int j = 0; j < size; j++) {
                List<Integer> list = res.get(j);
                List<Integer> newList = new ArrayList<>(list);
                newList.add(nums[i]);
                res.add(newList);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode78 Solution = new Leetcode78();

        int[] test1Array = new int[]{1, 2, 3, 4, 5};
        System.out.println(Solution.subsets(test1Array).toString());

        int[] test2Array = new int[]{2, 8, 10};
        System.out.println(Solution.subsets(test2Array).toString());

    }

}

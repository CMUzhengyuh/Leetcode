import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode491 {

    private List<List<Integer>> res;
    public List<List<Integer>> findSubsequences(int[] nums) {
        res = new ArrayList<>();
        DFS(nums,0,new ArrayList());
        return res;
    }

    private void DFS(int[] nums, int start, List<Integer> list)
    {
        if (list.size() > 1) res.add(new ArrayList(list));
        Set<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++)
        {
            if ((list.size() == 0 || list.get(list.size() - 1) <= nums[i]) && !set.contains(nums[i]))
            {
                list.add(nums[i]);
                DFS(nums,i + 1, list);
                list.remove(list.size() - 1);
                set.add(nums[i]);
            }
        }
    }

    public static void main(String[] args) {
        Leetcode491 Solution = new Leetcode491();

        int[] test1nums = new int[]{4, 6, 7, 7};
        System.out.println(Solution.findSubsequences(test1nums));

        int[] test2nums = new int[]{1, 2, 3, 4, 5, 1, 1, 1};
        System.out.println(Solution.findSubsequences(test2nums));
    }
}
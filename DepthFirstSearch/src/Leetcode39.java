import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Leetcode 39 - Combination Sum
 */
public class Leetcode39 {

    private List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        DFS(candidates, target, 0, new ArrayList<>());
        return res;

    }

    private void DFS(int[] candidates, int target, int index, List<Integer> list) {
        if (target == 0) {
            /**
             * DEBUG: res.add(list) -> [[], [], [], ...]
             * REASON: Reference type is mutable
             */
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            list.add(candidates[i]);
            DFS(candidates, target - candidates[i], i, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Leetcode39 Solution = new Leetcode39();

        int[] test1Array = new int[]{2, 3, 5};
        System.out.println(Solution.combinationSum(test1Array, 8).toString());

        int[] test2Array = new int[]{2, 3, 5, 7, 9, 10, 15, 18};
        System.out.println(Solution.combinationSum(test2Array, 27).toString());

    }
}

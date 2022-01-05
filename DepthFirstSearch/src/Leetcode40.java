import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Leetcode 40 - Combination Sum II
 */
public class Leetcode40 {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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

        if (index == candidates.length) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            /**
             * Truncate the duplicate candidate - choose the left possible candidate among all duplicates
             */
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            DFS(candidates, target - candidates[i], i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Leetcode40 Solution = new Leetcode40();

        int[] test1Array = new int[]{2, 3, 5};
        System.out.println(Solution.combinationSum2(test1Array, 8).toString());

        int[] test2Array = new int[]{2, 3, 5, 7, 9, 10, 15, 18};
        System.out.println(Solution.combinationSum2(test2Array, 27).toString());

        int[] test3Array = new int[]{1, 1, 2, 5, 6, 7, 10};
        System.out.println(Solution.combinationSum2(test3Array, 13).toString());

    }
}

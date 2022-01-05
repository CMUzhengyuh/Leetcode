import java.util.ArrayList;
import java.util.List;
/**
 * Leetcode 46 - Permutations
 */
public class Leetcode46 {

    List<List<Integer>> res;
    boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        visited = new boolean[nums.length];
        DFS(new ArrayList<>(), nums);
        return res;
    }

    private void DFS(List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            list.add(nums[i]);
            visited[i] = true;
            DFS(list, nums);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Leetcode46 Solution = new Leetcode46();

        int[] test1Array = new int[]{2, 3, 4, 5};
        System.out.println(Solution.permute(test1Array).toString());

        int[] test2Array = new int[]{2, 3, 4};
        System.out.println(Solution.permute(test2Array).toString());

    }
}

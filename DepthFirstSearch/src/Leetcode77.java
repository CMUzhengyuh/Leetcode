import java.util.ArrayList;
import java.util.List;
/**
 * Leetcode 77 - Combinations
 */
public class Leetcode77 {
    List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        DFS(new ArrayList<>(), n, 1, k);
        return res;
    }

    private void DFS(List<Integer> list, int n, int cur, int k) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        int size = list.size();
        /**
         * Truncate some numbers according to the size:
         * combine(6, 3) - The range of the first selected number should be [1, 4] rather than [1, 6]
         */
        for (int i = cur; i <= n + 1 - (k - size); i++) {
            list.add(i);
            DFS(list, n, i + 1, k);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Leetcode77 Solution = new Leetcode77();

        System.out.println(Solution.combine(5, 2).toString());
        System.out.println(Solution.combine(5, 3).toString());

    }
}

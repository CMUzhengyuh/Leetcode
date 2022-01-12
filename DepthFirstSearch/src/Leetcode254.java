import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 254 - Factor Combinations
 */
public class Leetcode254{

    private List<List<Integer>> res;

    public List<List<Integer>> getFactors(int n) {

        res = new ArrayList<>();
        DFS(n, new ArrayList<>(), 2);
        /**
         * Truncate the record of [n]
         */
        res.remove(res.size() - 1);
        return res;
    }

    private void DFS(int n, List<Integer> list, int start) {
        if (n == 1) {
            if (list.size() > 1) {
                res.add(new ArrayList<>(list));
            }
        }

        for (int i = start; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                list.add(i);
                DFS(n / i, list, i);
                list.remove(list.size() - 1);
            }
        }
        /**
         * Add the number itself
         */
        list.add(n);
        res.add(new ArrayList<>(list));
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        Leetcode254 Solution = new Leetcode254();

        System.out.println(Solution.getFactors(120));

        System.out.println(Solution.getFactors(1440));

        System.out.println(Solution.getFactors(10000));

    }
}
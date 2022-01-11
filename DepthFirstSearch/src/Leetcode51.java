import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Leetcode 51 - N-Queens
 */
public class Leetcode51 {

    List<List<String>> res;

    Set<Integer> columnSet, sumSet, diffSet;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        columnSet = new HashSet<>();
        sumSet = new HashSet<>();
        diffSet = new HashSet<>();

        DFS(new int[n], 0);
        return res;
    }

    private void DFS(int[] queen, int i) {
        int n = queen.length;
        if (i == queen.length) {
            List<String> list = new ArrayList<>();
            for (int m = 0; m < n; m++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(j == queen[m] ? 'Q' : '.');
                }
                list.add(sb.toString());
            }
            res.add(list);
            return;
        }
        for (int j = 0; j < n; j++) {
            if (!columnSet.contains(j) && !sumSet.contains(i + j) && !diffSet.contains(i - j)) {
                queen[i] = j;

                columnSet.add(j);
                sumSet.add(i + j);
                diffSet.add(i - j);

                DFS(queen, i + 1);

                columnSet.remove(j);
                sumSet.remove(i + j);
                diffSet.remove(i - j);
            }
        }
    }

    public static void main(String[] args) {
        Leetcode51 Solution = new Leetcode51();

        System.out.println(Solution.solveNQueens(3));

        System.out.println(Solution.solveNQueens(6));

        System.out.println(Solution.solveNQueens(9));
    }

}
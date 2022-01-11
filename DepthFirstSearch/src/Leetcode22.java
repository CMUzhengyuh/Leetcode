import java.util.ArrayList;
import java.util.List;
/**
 * Leetcode 22 - Generate Parentheses
 */
public class Leetcode22{

    private List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        DFS(sb, n, n);
        return res;
    }

    private void DFS(StringBuilder sb, int left, int right) {
        if (left == 0 && right == 0) {
            String str = sb.toString();
            res.add(str);
            return;
        }

        if (left > 0) {
            sb.append('(');
            DFS(sb, left - 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right > left) {
            sb.append(')');
            DFS(sb, left, right - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        Leetcode22 Solution = new Leetcode22();

        System.out.println(Solution.generateParenthesis(2));

        System.out.println(Solution.generateParenthesis(4));

        System.out.println(Solution.generateParenthesis(6));
    }
}
import java.util.ArrayList;
import java.util.List;
/**
 * Leetcode 17 - Letter Combinations of a Phone Number
 */
public class Leetcode17 {
    private String[] word = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private List<String> res;

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if (digits.length() == 0) return res;
        DFS(digits, 0, new StringBuilder());
        return res;
    }

    private void DFS(String digits, int pos, StringBuilder sb) {
        if (pos == digits.length()) {
            res.add(sb.toString());
            return;
        }

        String cur = word[digits.charAt(pos) - '2'];
        for (int i = 0; i < cur.length(); i++) {
            sb.append(cur.charAt(i));
            DFS(digits, pos + 1, sb);
            /**
             * StringBuilder: deleteCharAt(int pos)
             * Delete the character with index = pos
             */
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    public static void main(String[] args) {
        Leetcode17 Solution = new Leetcode17();

        String test1String = "";
        System.out.println(Solution.letterCombinations(test1String));

        String test2String = "23";
        System.out.println(Solution.letterCombinations(test2String));

        String test3String = "7569";
        System.out.println(Solution.letterCombinations(test3String));
    }
}

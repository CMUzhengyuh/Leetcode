import java.util.ArrayList;
import java.util.List;
/**
 * Leetcode 93 - Restore IP Addresses
 */
public class Leetcode93 {

    List<String> res;

    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        DFS(s, 0, new ArrayList<>());
        return res;
    }

    private void DFS(String s, int nextIndex, List<String> path) {
        if (nextIndex == s.length() && path.size() == 4) {
            StringBuilder sb = new StringBuilder();
            sb.append(path.get(0)).append('.');
            sb.append(path.get(1)).append('.');
            sb.append(path.get(2)).append('.');
            sb.append(path.get(3));
            res.add(sb.toString());
            return;
        }
        if (path.size() >= 4) {
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (nextIndex + i <= s.length()) {
                int num = Integer.valueOf(s.substring(nextIndex, nextIndex + i));
                if (num > 255 || (i > 1 && s.charAt(nextIndex) == '0')) continue;
                path.add(s.substring(nextIndex, nextIndex + i));
                DFS(s, nextIndex + i, path);
                path.remove(path.size() - 1);
            }
        }
        return;
    }

    public static void main(String[] args) {
        Leetcode93 Solution = new Leetcode93();

        String test1IP = "25525511135";
        System.out.println(Solution.restoreIpAddresses(test1IP).toString());

        String test2IP = "101023";
        System.out.println(Solution.restoreIpAddresses(test2IP).toString());

    }
}

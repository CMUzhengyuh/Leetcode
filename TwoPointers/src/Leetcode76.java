import java.util.HashMap;
import java.util.Map;
/**
 * Leetcode 76 - Minimum Window Substring ***
 */
public class Leetcode76 {
    public String minWindow(String s, String t) {
        String res = "";
        char[] source = s.toCharArray(), target = t.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int resLen = source.length + 1, left = 0, visited = 0, m = source.length, n = target.length;
        for (char c : target) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < m; i++) {
            char c = source[i];
            if (!map.containsKey(c)) {
                continue;
            }
            if (map.get(c) == 1) {
                visited++;
            }
            map.put(c, map.get(c) - 1);
            if (visited == map.size()) {
                while (left < i && (map.getOrDefault(source[left], -1) < 0) ) {
                    if (map.containsKey(source[left])) {
                        map.put(source[left], map.get(source[left]) + 1);
                    }
                    left++;
                }
                if (i - left + 1 < resLen) {
                    res = s.substring(left, i + 1);
                    resLen = i - left + 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode76 Solution = new Leetcode76();

        String test1Source = "ADOBECODEBANC", test1Target = "ABC";
        System.out.println(Solution.minWindow(test1Source, test1Target));

        String test2Source = "ADOBECODEBANC", test2Target = "ABCC";
        System.out.println(Solution.minWindow(test2Source, test2Target));
    }
}

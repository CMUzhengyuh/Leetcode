/**
 * Leetcode 3 - Longest Substring Without Repeating Characters
 */
public class Leetcode3 {
    public int lengthOfLongestSubstring(String s) {
        boolean[] visited = new boolean[255];
        char[] ch = s.toCharArray();
        int left = 0, right = 0, res = 0;
        for (right = 0; right < ch.length; right++) {
            if (visited[ch[right] - 0]) {
                while (ch[left] != ch[right]) {
                    visited[ch[left++] - 0] = false;
                }
                left++;
            } else {
                visited[ch[right] - 0] = true;
            }
            res = Math.max(right - left + 1, res);
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode3 Solution = new Leetcode3();

        String test1String = "^&*$&^*(";
        System.out.println(Solution.lengthOfLongestSubstring(test1String));

        String test2String = "hdliwgopqeoqiuasdgj";
        System.out.println(Solution.lengthOfLongestSubstring(test2String));
    }
}

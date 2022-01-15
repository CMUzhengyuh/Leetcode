import java.util.Stack;
/**
 * Leetcode 316 - Remove Duplicate Letters ***
 */
public class Leetcode316 {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        char[] ch = s.toCharArray();
        boolean[] visited = new boolean[26];
        Stack<Character> stack = new Stack<>();
        for (char c : ch) {
            count[c - 'a']++;
        }
        for (char c : ch) {
            count[c - 'a']--;
            if (visited[c - 'a']) continue;
            while (!stack.isEmpty() && stack.peek() > c && count[stack.peek() - 'a'] > 0) {
                visited[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            visited[c - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Leetcode316 Solution = new Leetcode316();

        String test1String = "bcabc";
        System.out.println(Solution.removeDuplicateLetters(test1String));

        String test2String = "cbacdcbc";
        System.out.println(Solution.removeDuplicateLetters(test2String));
    }
}



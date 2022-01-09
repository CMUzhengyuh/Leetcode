import java.util.Stack;
/**
 * Leetcode 1209 - Remove All Adjacent Duplicates In String II
 */
public class Leetcode1209 {
    public String removeDuplicates(String s, int k) {
        Stack<int[]> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            int val = c - 'a';
            if (!stack.isEmpty() && val == stack.peek()[0]) {
                int[] cur = stack.pop();
                cur[1]++;
                if (cur[1] != k) {
                    stack.add(cur);
                }
            } else {
                stack.add(new int[]{val, 1});
            }
        }
        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            for (int i = 0; i < cur[1]; i++) {
                sb.append((char) (cur[0] + 'a'));
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Leetcode1209 Solution = new Leetcode1209();

        String test1String = "abccabb";
        System.out.println(Solution.removeDuplicates(test1String, 2));

        String test2String = "deeedbbcccbdaa";
        System.out.println(Solution.removeDuplicates(test2String, 3));
    }
}
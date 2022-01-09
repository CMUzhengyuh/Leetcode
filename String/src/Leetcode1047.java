import java.util.Stack;
/**
 * Leetcode 1047 - Remove All Adjacent Duplicates In String
 */
public class Leetcode1047 {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && c == stack.peek()) {
                stack.pop();
            } else {
                stack.add(c);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Leetcode1047 Solution = new Leetcode1047();

        String test1String = "abccabb";
        System.out.println(Solution.removeDuplicates(test1String));

        String test2String = "abbccbbdda";
        System.out.println(Solution.removeDuplicates(test2String));
    }
}


import java.util.Stack;
/**
 * Leetcode 402 - Remove K Digits
 */
public class Leetcode402 {
    public String removeKdigits(String num, int k) {
        int left = k;
        Stack<Character> stack = new Stack<>();
        char[] ch = num.toCharArray();
        for (char c : ch) {
            /**
             * Remove digits to make the number smaller
             */
            while (!stack.isEmpty() && c < stack.peek() && left-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        /**
         * Remove digits from tail
         */
        while (!stack.isEmpty() && left-- > 0) {
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb = sb.reverse();
        /**
         * Remove head '0's
         */
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.delete(0, 1);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        Leetcode402 Solution = new Leetcode402();

        String test1Num = "10200";
        System.out.println(Solution.removeKdigits(test1Num, 1));

        String test2Num = "1432219";
        System.out.println(Solution.removeKdigits(test2Num, 3));

        String test3Num = "9";
        System.out.println(Solution.removeKdigits(test3Num, 1));
    }
}
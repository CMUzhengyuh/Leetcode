import java.util.Stack;
/**
 * 11th - Leetcode 20 - Valid Parentheses
 */
public class ValidParentheses {
    /**
     * Solution: Stack
     * TC: O(n)
     * SC: O(n)
     */
    public boolean isValid(String s) {
        /**
         * Stack to store left parenthesis
         */
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            switch(ch) {
                case ')':
                    /**
                     * Right parenthesis: check stack top does not match - return false
                     */
                    if (stack.isEmpty() || stack.peek() != '(') {
                        return false;
                    }
                    stack.pop();
                    break;
                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') {
                        return false;
                    }
                    stack.pop();
                    break;
                case '}':
                    if (stack.isEmpty() || stack.peek() != '{') {
                        return false;
                    }
                    stack.pop();
                    break;
                default:
                    /**
                     * Left parenthesis: add to stack
                     */
                    stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}

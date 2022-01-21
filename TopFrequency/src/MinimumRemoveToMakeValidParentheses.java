import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
/**
 * 10th - Leetcode 1249 - Minimum Remove to Make Valid Parentheses
 */
public class MinimumRemoveToMakeValidParentheses {
    /**
     * Solution 1: Stack
     * TC: O(n)
     * SC: O(n)
     */
    public String minRemoveToMakeValidStack(String s) {
        Set<Integer> toRemove = new HashSet<>();
        /**
         * Stack to check the pair of parentheses
         */
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } if (s.charAt(i) == ')') {
                /**
                 * No left parenthesis to match - pop
                 */
                if (stack.isEmpty()) {
                    toRemove.add(i);
                } else {
                    stack.pop();
                }
            }
        }
        /**
         * No right parenthesis to match
         */
        while (!stack.isEmpty()) toRemove.add(stack.pop());
        /**
         * Convert to result
         */
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!toRemove.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    /**
     * Solution 2: Breadth First Search
     * Time Limit Exceeded
     */
    public String minRemoveToMakeValidBFS(String s) {
        if (isValidString(s)) return s;
        Set<String> set = new HashSet<>();
        set.add(s);
        Deque<String> q = new ArrayDeque();
        q.addLast(s);
        while (true) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.removeFirst();
                for (int j = 0; j < cur.length(); j++) {
                    if (cur.charAt(j) == '(' || cur.charAt(j) == ')') {
                        String str = cur.substring(0, j) + cur.substring(j + 1);
                        if (!set.contains(str)) {
                            if (isValidString(str)) return str;
                            set.add(str);
                            q.addLast(str);
                        }
                    }
                }
            }
        }
    }

    private boolean isValidString(String s) {
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') count++;
            if (ch == ')') count--;
            if (count < 0) return false;
        }
        return count == 0;
    }
}

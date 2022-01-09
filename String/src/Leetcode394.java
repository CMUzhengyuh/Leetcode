import java.util.Stack;

/**
 * Leetcode 394 - Decode String ***
 */
public class Leetcode394 {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray())
        {
            if (c != ']')
                stack.push(c);
            else
            {
                /**
                 * Recover the word
                 */
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && Character.isLetter(stack.peek()))
                    sb.insert(0, stack.pop());
                String word = sb.toString();
                /**
                 * Remove '['
                 */
                stack.pop();
                /**
                 * Recover the number
                 */
                sb = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek()))
                    sb.insert(0, stack.pop());
                int count = Integer.valueOf(sb.toString());
                while (count > 0)
                {
                    for(char w : word.toCharArray())
                        stack.push(w);
                    count--;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty())
            res.insert(0, stack.pop());
        return res.toString();
    }

    public static void main(String[] args) {
        Leetcode394 Solution = new Leetcode394();

        String test1String = "3[a2[c]]";
        System.out.println(Solution.decodeString(test1String));

        String test2String = "2[abc]3[cd]ef";
        System.out.println(Solution.decodeString(test2String));

    }
}
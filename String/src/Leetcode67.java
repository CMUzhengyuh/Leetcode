import java.util.SimpleTimeZone;
import java.util.Stack;

public class Leetcode67 {
    public String addBinary(String a, String b) {
        Stack<Integer> stack = new Stack<>();
        int tempA = a.length() - 1, tempB = b.length() - 1, carry = 0;
        while (tempA >= 0 || tempB >= 0) {
            int digA = tempA >= 0 ? a.charAt(tempA--) - '0' : 0, digB = tempB >= 0 ? b.charAt(tempB--) - '0' : 0;
            int dig = digA + digB + carry;
            stack.add(dig % 2);
            carry = dig / 2;
        }
        if (carry != 0) {
            stack.add(carry);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Leetcode67 Solution = new Leetcode67();

        String test1A = "111", test1B = "1";
        System.out.println(Solution.addBinary(test1A, test1B));

        String test2A = "1001", test2B = "10011010";
        System.out.println(Solution.addBinary(test2A, test2B));
    }
}

import java.util.Stack;
/**
 * Leetcode 234 - Palindrome Linked List
 */
public class Leetcode234 {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        Stack<Integer> stack = new Stack<>();
        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        /**
         * Circumvent the number in the middle
         */
        if (fast != null) {
            slow = slow.next;
        }
        while (slow != null) {
            if (slow.val != stack.pop()) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Leetcode234 Soltution = new Leetcode234();

        ListNode test1LinkedList = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(1))))))));
        System.out.println(Soltution.isPalindrome(test1LinkedList));

        ListNode test2LinkedList = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2))));
        System.out.println(Soltution.isPalindrome(test2LinkedList));
    }
}

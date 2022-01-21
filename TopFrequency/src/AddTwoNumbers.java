/**
 * 9th - Leetcode 2 - Add Two Numbers
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /**
         * Carry number and digits
         */
        int carry = 0, num = 0;
        ListNode l = new ListNode(-1), temp = l;
        /**
         * When two LinkedList not arrive to the end
         */
        while (l1 != null && l2 != null) {
            num = l1.val + l2.val + carry;
            carry = num / 10;
            num = num % 10;
            temp.next = new ListNode(num);
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        /**
         * One LinkedList reaches the end - traverse the other one
         */
        while (l1 != null) {
            num = l1.val + carry;
            carry = num / 10;
            num = num % 10;
            temp.next = new ListNode(num);
            temp = temp.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            num = l2.val + carry;
            carry = num / 10;
            num = num % 10;
            temp.next = new ListNode(num);
            temp = temp.next;
            l2 = l2.next;
        }
        /**
         * Possible carry digit before the first digit
         */
        if (carry != 0) temp.next = new ListNode(1);
        return l.next;
    }

    public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

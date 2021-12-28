/**
 * Leetcode 2 - Add Two Numbers
 */
public class Leetcode2 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int add = 0, num = 0;
        ListNode l = new ListNode(-1), temp = l;
        while (l1 != null && l2 != null) {
            num = l1.val + l2.val + add;
            add = num / 10;
            num = num % 10;
            temp.next = new ListNode(num);
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            num = l1.val + add;
            add = num / 10;
            num = num % 10;
            temp.next = new ListNode(num);
            temp = temp.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            num = l2.val + add;
            add = num / 10;
            num = num % 10;
            temp.next = new ListNode(num);
            temp = temp.next;
            l2 = l2.next;
        }
        if (add != 0) temp.next = new ListNode(1);
        return l.next;
    }

    public static void main(String[] args) {
        ListNode test1L1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode test1L2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.println(addTwoNumbers(test1L1, test1L2).toString());

        ListNode test2L1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        ListNode test2L2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))));
        System.out.println(addTwoNumbers(test2L1, test2L2).toString());

    }
}

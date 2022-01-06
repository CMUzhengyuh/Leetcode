/**
 * Leetcode 876 - Middle of the Linked List
 */
public class Leetcode876 {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Leetcode876 Soltution = new Leetcode876();

        ListNode test1LinkedList = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(1))))))));
        System.out.println(Soltution.middleNode(test1LinkedList).toString());

        ListNode test2LinkedList = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(1)))))));
        System.out.println(Soltution.middleNode(test2LinkedList).toString());
    }
}

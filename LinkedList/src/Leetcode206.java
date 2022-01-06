/**
 * Leetcode 206 - Reverse Linked List
 */
public class Leetcode206 {
    /**
     * Iterative Solution
     */
    public ListNode reverseListIterative(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1, head), tail = dummy, temp = null;
        while (tail.next != null) {
            tail = tail.next;
        }
        while (dummy.next != tail) {
            temp = dummy.next;
            dummy.next = dummy.next.next;
            temp.next = tail.next;
            tail.next = temp;
        }
        return tail;
    }

    /**
     * Recursive Solution
     */
    private ListNode root = null;

    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode last = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public static void main(String[] args) {
        Leetcode206 Soltution = new Leetcode206();

        ListNode test1LinkedList = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8))))))));
        System.out.println(Soltution.reverseListIterative(test1LinkedList).toString());

        ListNode test2LinkedList = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7)))))));
        System.out.println(Soltution.reverseListRecursive(test2LinkedList).toString());
    }
}

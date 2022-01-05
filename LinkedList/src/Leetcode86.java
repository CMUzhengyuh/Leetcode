/**
 * Leetcode 86 - Partition List
 */
public class Leetcode86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        ListNode slow = dummy;
        ListNode temp = new ListNode(0);
        ListNode fast = temp;
        while (head != null) {
            if (head.val < x) {
                slow.next = new ListNode(head.val);
                slow = slow.next;
            } else {
                fast.next = new ListNode(head.val);
                fast = fast.next;
            }
            head = head.next;
        }
        slow.next = temp.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        Leetcode86 Solution = new Leetcode86();

        ListNode testLinkedList = new ListNode(8, new ListNode(7, new ListNode(6, new ListNode(5, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(1))))))));
        System.out.println(Solution.partition(testLinkedList, 2).toString());
        System.out.println(Solution.partition(testLinkedList, 4).toString());
        System.out.println(Solution.partition(testLinkedList, 6).toString());

    }
}

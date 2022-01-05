/**
 * Leetcode 141 - Linked List Cycle
 */
public class Leetcode141 {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            /**
             * DEBUG: 1 -> 2 (2 -> 1) Time Limit Exceeded
             * REASON: Slow and fast pointer starts from head at the same time, move pointers after
             *         judgement will lead to false result
             */
            if (slow == fast) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Leetcode141 Solution = new Leetcode141();

        ListNode node1 = new ListNode(-1);
        ListNode node2 = new ListNode(-1);
        node1.next = node2;
        node2.next = node1;
        System.out.println(Solution.hasCycle(node1));
    }
}

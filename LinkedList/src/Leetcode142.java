/**
 * Leetcode 142 - Linked List Cycle II
 */
public class Leetcode142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            /**
             * Assume that slow pointer travels d steps and fast pointer travels 2d steps in that
             * d is the multiple of circle length. Afterwards, reset fast pointer to the start and
             * change the speed to the same with slow pointer. Two pointers will meet at the point.
             */
            if (slow == fast) break;
        }
        /**
         * Check if can form a cycle
         */
        if (fast.next == null || fast.next.next == null) return null;
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}

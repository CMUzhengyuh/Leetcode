/**
 * Leetcode 160 - Intersection of Two Linked Lists
 */
public class Leetcode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode tempA = headA, tempB = headB;
        while (tempA != tempB) {
            /**
             * Assume that LinkedList A has length a and LinkedList B has length b, they intersects
             * at last l nodes. When one list reaches the end (e.g. tempA travels to null), tempA
             * restarts begin at headB so that after (a - l) + l + (b - l), tempA & tempB will
             * arrive at intersection point.
             */
            tempA = tempA == null ? headB : tempA.next;
            tempB = tempB == null ? headA : tempB.next;
        }
        return tempA;
    }
}

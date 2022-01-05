/**
 * Leetcode 25 - Reverse Nodes in K-Group
 */
public class Leetcode25 {
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode result = new ListNode(-1), l = result, part = null, temp = head, tail = head;
        int count = 0;
        while (temp != null) {
            count++;
            /**
             * Record the reverse part of LinkedList
             */
            part = new ListNode(temp.val, part);
            temp = temp.next;
            /**
             * Complete part - add the reverse part
             */
            if (count == k) {
                count = 0;
                tail = temp;
                l.next = part;
                part = null;
                while (l.next != null) {
                    l = l.next;
                }
            }
        }
        /**
         * Incomplete part - add directly
         */
        l.next = tail;
        return result.next;
    }

    public static void main(String[] args) {
        ListNode testL = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8))))))));
        System.out.println(reverseKGroup(testL, 2).toString());
        System.out.println(reverseKGroup(testL, 3).toString());
        System.out.println(reverseKGroup(testL, 4).toString());
        System.out.println(reverseKGroup(testL, 5).toString());
        System.out.println(reverseKGroup(testL, 6).toString());
    }
}

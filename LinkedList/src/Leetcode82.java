/**
 * Leetcode 82 - Remove Duplicates from Sorted List II
 */
public class Leetcode82 {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1), temp = head, prev = dummy;
        dummy.next = head;
        while (temp != null && temp.next != null) {
            /**
             * Need to truncate the duplicates
             */
            if (temp.val == temp.next.val) {
                ListNode nextNode = temp.next;
                while (nextNode != null && nextNode.val == temp.val) {
                    nextNode = nextNode.next;
                }
                prev.next = nextNode;
                temp = nextNode;
            } else {
                prev = temp;
                temp = temp.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode test1L = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8))))))));
        System.out.println(deleteDuplicates(test1L).toString());

        ListNode test2L = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5, new ListNode(6))))))));
        System.out.println(deleteDuplicates(test2L).toString());

        ListNode test3L = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(5))))))));
        System.out.println(deleteDuplicates(test3L).toString());
    }
}

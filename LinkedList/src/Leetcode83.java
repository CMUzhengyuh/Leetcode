/**
 * Leetcode 83 - Remove Duplicates from Sorted List
 */
public class Leetcode83 {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            ListNode nextNode = temp.next;
            while (nextNode != null && nextNode.val == temp.val) {
                nextNode = nextNode.next;
            }
            temp.next = nextNode;
            temp = temp.next;
        }
        return head;
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

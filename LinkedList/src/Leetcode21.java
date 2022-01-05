/**
 * Leetcode 21 - Merge Two Sorted Lists
 */
public class Leetcode21 {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode l = new ListNode(-1), temp = l;
        while (list1 != null && list2 != null) {
            temp.next = new ListNode(list1.val < list2.val ? list1.val : list2.val);
            temp = temp.next;
            if (list1.val < list2.val) {
                list1 = list1.next;
            } else list2 = list2.next;
        }
        if (list1 != null) temp.next = list1;
        else temp.next = list2;
        return l.next;
    }

    public static void main(String[] args) {
        ListNode test1L1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode test1L2 = new ListNode(1, new ListNode(2, new ListNode(5, new ListNode(6))));
        System.out.println(mergeTwoLists(test1L1, test1L2).toString());

        ListNode test2L1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        ListNode test2L2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))));
        System.out.println(mergeTwoLists(test2L1, test2L2).toString());

    }
}

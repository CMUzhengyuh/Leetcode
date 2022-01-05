/**
 * Leetcode 328 - Odd Even Linked List
 */
public class Leetcode328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head ;
        ListNode odd = head, even = head.next, temp = head.next ;
        while (even != null && even.next != null)
        {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = temp ;
        return head ;
    }

    public static void main(String[] args) {
        Leetcode328 Soltution = new Leetcode328();

        ListNode test1LinkedList = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(1))))))));
        System.out.println(Soltution.oddEvenList(test1LinkedList).toString());

        ListNode test2LinkedList = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2))));
        System.out.println(Soltution.oddEvenList(test2LinkedList).toString());
    }

}

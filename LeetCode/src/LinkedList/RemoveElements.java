package LinkedList;

/**
 * Created by Rohith Vallu on 11/3/2015.
 *
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 */



public class RemoveElements {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode p = helper;

        while (p.next != null) {
            if (p.next.val == val) {
                ListNode next = p.next;
                p.next = next.next;
            } else {
                p = p.next;
            }
        }
        return helper.next;
    }
}

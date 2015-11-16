package LinkedList;



/**
 * Created by Rohith Vallu on 11/15/2015.
 */
public class ReverseLinkedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public static ListNode reverseByIteration(ListNode head){
        if(head==null || head.next == null)
            return head;

        ListNode p1 = head;
        ListNode p2 = head.next;

        head.next = null;
        while(p1!= null && p2!= null){
            ListNode t = p2.next;
            p2.next = p1;
            p1 = p2;
            if (t!=null){
                p2 = t;
            }else{
                break;
            }
        }

        return p2;
    }

    public static ListNode reverseByRecursion(ListNode head){
        if(head==null || head.next == null)
            return head;

        ListNode second = head.next;
        head.next = null;
        ListNode rest = reverseByRecursion(second);

        second.next=head;

        return rest;


    }

    public static void main(String[] args) {

        ListNode root = new ListNode(1);
        root.next= new LinkedList.ReverseLinkedList.ListNode(2);
        root.next.next= new LinkedList.ReverseLinkedList.ListNode(3);
        root.next.next.next= new LinkedList.ReverseLinkedList.ListNode(4);
//        root.next.next.next.next = null;

        ListNode check = reverseByIteration(root);
        ListNode root2 = check;
        while(check!=null){
            System.out.print(" "+check.val);
            check = check.next;
        }

        System.out.println();

        ListNode doubleCheck = reverseByRecursion(root2);
        while(doubleCheck!=null){
            System.out.print(" "+doubleCheck.val);
            doubleCheck = doubleCheck.next;
        }
    }
}

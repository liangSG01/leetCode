package 完全反转链表;

import java.util.List;

class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }
}
public class Solve {

    public static ListNode reverse(ListNode head){
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = null;

        while(head != null){
            ListNode next = head.next;
            head.next = pre;

            pre = head;
            head = next;
        }
        return pre;
    }
    public static void main(String[] args) {
        // 1 2 3 4 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode newHead = reverse(head);
        while (newHead != null) {
            System.out.print(newHead.val);
            newHead = newHead.next;
        }
    }
}

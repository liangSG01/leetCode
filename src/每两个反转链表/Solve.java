package 每两个反转链表;

import java.util.List;

class ListNode{
    int val;
    ListNode next;
    public ListNode(){}
    public ListNode(int val){
        this.val = val;
    }
    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }

}
public class Solve {
    public static ListNode solve(ListNode head){
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while(head != null && head.next != null){
            ListNode second = head.next;
            ListNode third = second.next;

            second.next = head;
            pre.next = second;
            head.next = third;

            pre = head;
            head = third;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        // 1 2 3 4 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode res = solve(head);

        while(res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }

    }
}

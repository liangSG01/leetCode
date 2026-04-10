//package leetcodehot100_0309.相交链表;
//
//import java.util.List;
//
//public class Solve {
//    class ListNode {
//        int val;
//        ListNode next;
//        public ListNode(){};
//        public ListNode(int val){
//            this.val = val;
//        }
//        public ListNode(int val, ListNode next){this.val = val; this.next = next};
//    }
//    public static ListNode func(ListNode head1, ListNode head2){
//        ListNode A = head1, B = head2;
//        while (A != B){
//            A = A != null ? A.next : head1;
//            B = B != null ? B.next : head2;
//        }
//        return A;
//    }
//    public static void main(String[] args) {
//
//    }
//}

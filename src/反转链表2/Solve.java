package 反转链表2;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solve {
    // 0 1 2 3 4 5
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode rightNode = dummy;
        ListNode leftNode = dummy;
        for(int i = 0; i < left - 1; i++){
            leftNode = leftNode.next;
        }
        for(int i = 0; i < right; i++){
            rightNode = rightNode.next;
        }

        ListNode firstNode = leftNode.next;
        ListNode suffixNode = rightNode.next;
        //断开链表
        leftNode.next = null;
        rightNode.next = null;

        leftNode.next = reverse(firstNode);
        while(firstNode.next != null){
            firstNode = firstNode.next;
        }
        firstNode.next = suffixNode;
        return dummy.next;
    }
    public static ListNode reverse(ListNode node){
        ListNode dummy = new ListNode(-1);
        dummy.next = node;
        ListNode pre = null;
        // 1 2 3 4
        while(node != null){
            ListNode nextNode = node.next;
            node.next = pre;
            pre = node;
            node = nextNode;
        }
        return pre;
    }
    private static void printList(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val);
            if (cur.next != null) System.out.print(" -> ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 构造链表 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("原链表：");
        printList(head);

        // 反转区间 [2, 4]
        Solve solver = new Solve();
        ListNode newHead = solver.reverseBetween(head, 2, 4);

        System.out.println("反转 [2,4] 后：");
        printList(newHead);
    }
}
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static void printList(ListNode p) {
        while (p !=null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
        System.out.println("NULL");
    }

    public static ListNode buildList() {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);;
        ListNode third = new ListNode(3);
        head.next = second;
        second.next = third;
        third.next = new ListNode(4);
        third.next.next = new ListNode(5);
        return head;
    }
}

public class SwapPairNode2 {

    //迭代实现,需要记录第一个节点的前驱节点
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;

        while (head != null && head.next != null) {
            // Nodes to be swapped
            ListNode first = head;
            ListNode second = head.next;

            // Swapping
            prev.next = second;
            first.next = second.next;
            second.next = first;

            // Reinitializing the head and prevNode for next swap
            prev = first;
            head = prev.next;
        }

        return dummy.next;
    }
}

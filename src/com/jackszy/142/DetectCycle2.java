public class DetectCycle2 {

    //Floyd 算法 ，快慢指针算法。
    public ListNode detectCycle(ListNode head) {
        ListNode ptr1 = head;
        ListNode ptr2 = null;
        ListNode fast = head;
        ListNode slow = head;
        while (slow !=null && fast !=null && fast.next !=null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ptr2 = slow;
                break;
            }
        }
        if (ptr2  == null)
            return null;

        while (ptr1 !=ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        return ptr1;
    }
}

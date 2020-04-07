import java.util.HashSet;
import java.util.Set;

public class DetectCycle {
    public static void main(String[] args) {

    }

    //set 判重，时间复杂度O(n),空间复杂度O(n)
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head !=null) {
            if (set.contains(head))
                return head;

            set.add(head);
            head = head.next;
        }

        return null;
    }
}

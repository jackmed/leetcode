import java.util.HashSet;
import java.util.Set;
import com.jackszy.ListNode;

public class HasCycle2 {
    /**
     * set去重解法： 用一个set记录以及遍历过的节点，如果有遍历到同一个节点两次，则链表存在环
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head !=null) {
            if (set.contains(head))
                return true;

            set.add(head);
            head = head.next;
        }

        return false;
    }
}

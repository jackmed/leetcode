/**
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class HasCycle {
    public static void main(String[] args) {

    }

    /**
     * 暴力解法，一定时间内如果还没有到链表尾部，大概率说明链表有环
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        long startTime = System.currentTimeMillis();
        while (head!= null) {
            head = head.next;
            //如果超出100ms，还没有到链表尾，则大概率有环
            if (System.currentTimeMillis() - startTime >=100)
                return true;
        }
        return false;
    }
}

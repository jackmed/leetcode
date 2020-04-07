/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 示例：
 * 给你这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 * 说明：
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseNodeInKGroup {
    public static void main(String[] args) {
        ListNode head = ListNode.buildList();
        ListNode.printList(new ReverseNodeInKGroup().reverseKGroup(head, 2));
    }

    /**
     * 自己的第一次递归实现，用到了递归，不能满足空间复杂度要求
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;

        int i = 0;
        ListNode lastInK = head;
        while (lastInK != null) {
            lastInK = lastInK.next;
            i++;
            if (i == k - 1)
                break;
        }
        //链表长度小于k，不翻转，直接返回
        if (i < k - 1 || lastInK == null)
            return head;

        ListNode nextStart = lastInK.next;
        //递归翻转后续的链表
        ListNode p = reverseKGroup(nextStart, k);

        //反转当前的k个元素
        ListNode curr = head.next;
        ListNode prev = head;
        while (curr != nextStart) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        head.next = p;
        return prev;
    }
}

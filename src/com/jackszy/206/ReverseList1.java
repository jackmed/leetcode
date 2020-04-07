/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseList1 {
    public static void main(String[] args) {
        ListNode head = ListNode.buildList();

        System.out.println("原链表为");
        printList(head);

        System.out.println("反转后的链表：");
        ListNode newHead = new ReverseList2().reverseList(head);
        printList(newHead);
    }

    //递归实现
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    private static void printList(ListNode p) {
        while (p !=null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
        System.out.println("NULL");
    }
}

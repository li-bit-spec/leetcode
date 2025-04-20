package 算法.链表;

/**
 * @author 李华宪
 * @Description
 * @create 2025-03-03 20:59
 */
public class 翻转链表 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode res = reverseList(head);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

    private static ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode();
        while (head != null) {
            // 记录下一个节点
            ListNode next = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = next;
        }
        return dummy.next;
    }
}

package 算法.链表;

/**
 * @author 李华宪
 * @Description
 * @create 2025-03-03 22:29
 */
public class 环形链表II142 {
    public static void main(String[] args) throws Exception {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        ListNode result = detectCycle(head);
        System.out.println(result.val);
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null; // 如果链表为空或只有一个节点，肯定没有环
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode cur = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                while (cur != slow) {
                    cur = cur.next;
                    slow = slow.next;
                }
                return cur;
            }
        }
        return null;
    }
}

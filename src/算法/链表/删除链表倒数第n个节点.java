package 算法.链表;

/**
 * @author 李华宪
 * @Description
 * @create 2025-01-17 22:37
 */
public class 删除链表倒数第n个节点 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int n = 2;
        head = removeNthFromEnd(head, n);
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        int index = 0;
        while (index <= n && fast != null) {
            fast = fast.next;
            index++;
        }
        // slow 指向的是被删除的前一个节点
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}

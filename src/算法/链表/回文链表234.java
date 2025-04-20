package 算法.链表;

/**
 * @author 李华宪
 * @Description
 * @create 2025-03-03 21:20
 */
public class 回文链表234 {
    public static void main(String[] args) throws Exception {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(head));
    }

    private static boolean isPalindrome(ListNode head) {
        // 先按链表翻转再判断，因为要求O(1)空间复杂度，所以翻转后半部分
        // 1. 先确定链表长度
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            length++;
        }
        // 2. 定位到中间节点
        ListNode mid = head;
        for (int i = 0; i < length / 2; i++) {
            mid = mid.next;
        }
        if (length % 2 != 0) {
            mid = mid.next;
        }
        ListNode next = reverseList(mid);
        // 3.开始遍历
        ListNode pre = head;
        while (next != null) {
            if (pre.val != next.val) {
                return false;
            }
            next = next.next;
            pre = pre.next;
        }
        return true;

    }

    private static ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode();
        while (head != null) {
            ListNode next = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = next;
        }
        return dummy.next;
    }

}

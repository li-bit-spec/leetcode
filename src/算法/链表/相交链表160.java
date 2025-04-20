package 算法.链表;

/**
 * @author 李华宪
 * @Description
 * @create 2025-03-03 21:41
 */
public class 相交链表160 {
    public static void main(String[] args) throws Exception {
        ListNode l1 = new ListNode(4);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(8);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(1);
        l2.next.next.next = l1.next.next;

        ListNode intersectionNode = getIntersectionNode(l1, l2);
        System.out.println(intersectionNode.val);
    }

    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 1. 先确定每个链表的长度
        int lengthA = 0;
        int lengthB = 0;
        ListNode currentA = headA;
        ListNode currentB = headB;
        while (currentA != null) {
            lengthA++;
            currentA = currentA.next;
        }
        while (currentB != null) {
            lengthB++;
            currentB = currentB.next;
        }
        // 2. 找到较长的链表和其头节点
        ListNode longerHead = lengthA > lengthB ? headA : headB;
        ListNode shorterHead = lengthA > lengthB ? headB : headA;
        int diff = Math.abs(lengthA - lengthB);
        // 3. 让较长的链表先走diff步
        for (int i = 0; i < diff; i++) {
            longerHead = longerHead.next;
        }
        // 4. 然后两条链表同时往前走，找到交点
        while (longerHead != shorterHead) {
            longerHead = longerHead.next;
            shorterHead = shorterHead.next;
        }
        return longerHead;
    }

}

package 算法.链表;

import java.util.Scanner;

public class 移除链表元素 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] parts = input.split("\\s+");
        ListNode dummy = new ListNode();
        ListNode node = dummy;
        for (String part : parts) {
            node.next = new ListNode(Integer.parseInt(part));
            node = node.next;
        }
        int val = scanner.nextInt();
        System.out.println(removeElements(dummy.next, val));
    }

    private static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode node = dummy;
        while (node.next != null) {
            if (node.next.val == val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }

        return dummy.next;
    }
}

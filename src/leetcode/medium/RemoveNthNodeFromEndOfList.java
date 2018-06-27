package leetcode.medium;

import leetcode.ListNode;

public class RemoveNthNodeFromEndOfList {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dumbNode = new ListNode(0);
        dumbNode.next = head;
        ListNode p1 = dumbNode;
        ListNode p2 = dumbNode;
        int j = 0;
        while (j < n) {
            p1 = p1.next;
            j++;
        }

        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        p2.next = p2.next.next;
        return dumbNode.next;
    }
}

package leetcode.medium;

import leetcode.ListNode;

public class SwapNodesInPairs {
    public static ListNode swapPairs(ListNode head) {
        ListNode dumbNode = new ListNode(-1);
        ListNode p1 = dumbNode;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            ListNode temp = p2.next.next;
            p1.next = p2.next;
            p1.next.next = p2;
            p1 = p2;
            p1.next = null;
            p2 = temp;
        }
        p1.next = p2;
        return dumbNode.next;
    }
}

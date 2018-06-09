package leetcode.easy;

import leetcode.ListNode;

public class HasCycle {
    public static boolean hasCycle(ListNode head) {
        ListNode revHead = head;
        ListNode prev = null;
        while (revHead != null) {
            ListNode temp = revHead.next;
            revHead.next = prev;

            prev = revHead;
            revHead = temp;
            if(revHead == head) return true;
        }
        return false;
    }
}

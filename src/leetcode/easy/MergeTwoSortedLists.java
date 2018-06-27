package leetcode.easy;

import leetcode.ListNode;

public class MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dumbNode = new ListNode(0);
        ListNode p = dumbNode;
        while (l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if(l1 == null) p.next = l2;
        else p.next = l1;
        return dumbNode.next;
    }
}

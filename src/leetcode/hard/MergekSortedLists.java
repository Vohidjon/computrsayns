package leetcode.hard;

import leetcode.ListNode;

public class MergekSortedLists {
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode dumbNode = new ListNode(-1);
        ListNode p = dumbNode;
        while (true) {
            int min = -1;
            for (int i = 0; i < lists.length; i++) {
                if(lists[i] != null) {
                    if(min == -1) min = i;
                    else if(lists[min].val > lists[i].val) min = i;
                }
            }
            if(min == -1) break;

            p.next = lists[min];
            p = p.next;
            lists[min] = lists[min].next;
        }
        return dumbNode.next;
    }

}

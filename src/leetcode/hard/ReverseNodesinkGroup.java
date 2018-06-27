package leetcode.hard;

import leetcode.ListNode;

public class ReverseNodesinkGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dumbNode = new ListNode(-1);
        ListNode p1 = dumbNode; // for appending the result
        ListNode p2 = head; // used for stepping forward to see if there are at least k nodes
        ListNode p3; // used for storing the start of group
        ListNode tempLastNode;
        while (p2 != null) {
            p3 = p2;
            // make sure there is at least k nodes to reverse
            for (int i = 0; i < k - 1; i++) {
                if(p2.next == null) {
                    p1.next = p3;
                    return dumbNode.next;
                }
                p2 = p2.next;
            }
            p2 = p2.next;
            tempLastNode = p3;
            p1.next = reverse(p3, null, p2);
            p1 = tempLastNode;
        }
        return dumbNode.next;
    }

    private static ListNode reverse(ListNode node, ListNode prevNode, ListNode lastNode) {
        ListNode tempNext = node.next;
        node.next = prevNode;
        if(tempNext == lastNode) {
            return node;
        }
        return reverse(tempNext, node, lastNode);
    }
}

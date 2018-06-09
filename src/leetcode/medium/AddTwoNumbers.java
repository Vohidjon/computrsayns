package leetcode.medium;

import leetcode.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
        ListNode sumNode = new ListNode(0);
        ListNode nextL1 = null, nextL2 = null;
        int sum;
        if(l1 == null && l2 == null) {
            if(carry == 0) return null;
            else {
                sumNode.val = 1;
                return sumNode;
            }
        } else if(l1 == null) {
            sum = l2.val + carry;
            nextL2 = l2.next;
        } else if(l2 == null) {
            sum = l1.val + carry;
            nextL1 = l1.next;
        } else {
            sum = l1.val + l2.val + carry;
            nextL1 = l1.next;
            nextL2 = l2.next;
        }
        sumNode.val = sum % 10;
        sumNode.next = addTwoNumbers(nextL1, nextL2, sum >= 10 ? 1 : 0);
        return sumNode;
    }
}

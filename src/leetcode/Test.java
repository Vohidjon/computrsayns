package leetcode;

import leetcode.easy.HasCycle;
import leetcode.easy.TwoSum;
import leetcode.hard.MedianOfTwoSortedArrays;
import leetcode.medium.AddTwoNumbers;
import leetcode.medium.FindMinInRotatedSortedArray;
import leetcode.medium.LongestPalindromicSubstring;
import leetcode.medium.LongestSubstringWithoutRepeatingCharacters;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        int[] result = TwoSum.twoSum(new int[]{2, 7, 11, 15}, 9);
//        System.out.println(Arrays.toString(result));

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

        ListNode nodeA = new ListNode(9);
        nodeA.next = new ListNode(4);
        nodeA.next.next = new ListNode(3);

        ListNode nodeB = new ListNode(9);
        nodeB.next = new ListNode(6);
        nodeB.next.next = new ListNode(9);
        ListNode sumNode = addTwoNumbers.addTwoNumbers(nodeA, nodeB);

        int sum = 0;
        do {
            sum = sum * 10 + sumNode.val;
            sumNode = sumNode.next;
        } while (sumNode != null);
        assert sum == 8131 : "Sum must be 8131 (reversed)";

        ListNode n1 = new ListNode(13);
        ListNode n2 = new ListNode(7);
        ListNode n3 = new ListNode(9);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n2;
//        System.out.println(HasCycle.hasCycle(n1));

        int[] nums = new int[]{/*3, 4, 5, 6, 7, 8,*/ /*2,*/ 1};
        assert FindMinInRotatedSortedArray.findMin(nums) == 1 : "Min should be 1";

//        System.out.println(LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("pwwkew"));
        int[] num1 = new int[]{3, 4, 7, 13, 15};
        int[] num2 = new int[]{1, 5, 7, 10, 14, 17, 20, 20};
//        System.out.println(MedianOfTwoSortedArrays.median(num1, num2));

//        System.out.println(LongestPalindromicSubstring.solution2("racecar"));
//        System.out.println(LongestPalindromicSubstring.solution2("babad"));
//        System.out.println(LongestPalindromicSubstring.solution2("cbbd"));
        System.out.println(LongestPalindromicSubstring.solution2("bb"));
        System.out.println(LongestPalindromicSubstring.solution2("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"));
        System.out.println(LongestPalindromicSubstring.solution2("babaddtattarrattatddetartrateedredividerb"));
    }
}

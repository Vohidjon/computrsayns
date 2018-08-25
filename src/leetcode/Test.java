package leetcode;


import leetcode.easy.BestTimeToBuyAndSellStock;
import leetcode.hard.BestTimeToBuyAndSellStockIII;
import leetcode.hard.DistinctSubsequences;
import leetcode.hard.PalindromePartitioningII;
import leetcode.hard.ScrambleString;
import leetcode.medium.LongestPalindromicSubstring;
import leetcode.medium.Triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        System.out.println(new PalindromePartitioningII().minCut("ababba"));
        System.out.println(new PalindromePartitioningII().minCut("aab"));
    }
}

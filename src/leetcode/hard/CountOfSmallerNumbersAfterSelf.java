package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        TreeNode root = new TreeNode(nums[nums.length - 1]);
        int[] counts = new int[nums.length];
        counts[counts.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            counts[i] = insert(root, nums[i]);
        }
        return null;
    }

    private int insert(TreeNode root, int num) {
        return 0;
    }

    private class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public int leftCount = 0;
        public int value;

        public TreeNode(int value) {
            this.value = value;
        }
    }
}

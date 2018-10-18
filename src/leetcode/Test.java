package leetcode;


import leetcode.medium.BinaryTreeLevelOrderTraversal;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        TreeNode root3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        root3.left = node9;
        root3.right = node20;
        node20.left = node15;
        node20.right = node7;
        List<List<Integer>> res = new BinaryTreeLevelOrderTraversal().levelOrder(root3);
    }
}

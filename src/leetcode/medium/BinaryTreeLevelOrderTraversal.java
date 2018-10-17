package leetcode.medium;

import jdk.nashorn.api.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        list.add(null);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        int i = 0;
        while (i < list.size()) {
            TreeNode elem = list.get(i);
            if (elem == null) {
                if (level.size() != 0) result.add(level);
                list.add(null);
                level = new ArrayList<>();
            } else {
                level.add(elem.val);
                if (elem.left != null) list.add(elem.left);
                if (elem.right != null) list.add(elem.right);
            }
            i++;
        }
        return result;
    }
}

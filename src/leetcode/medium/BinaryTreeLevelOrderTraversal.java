package leetcode.medium;


import java.util.*;

import leetcode.TreeNode;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<NodeWrapper> queue = new LinkedList<>();
        queue.add(new NodeWrapper(root));
        queue.add(new NodeWrapper());
        List<Integer> level = new ArrayList<>();
        while (!queue.isEmpty()) {
            NodeWrapper nodeWrapper = queue.poll();
            if (nodeWrapper.node == null && !level.isEmpty()) {
                result.add(level);
                level = new ArrayList<>();
                queue.add(new NodeWrapper());
            } else if (nodeWrapper.node != null) {
                level.add(nodeWrapper.node.val);
                if(nodeWrapper.node.left != null) queue.add(new NodeWrapper(nodeWrapper.node.left));
                if(nodeWrapper.node.right != null) queue.add(new NodeWrapper(nodeWrapper.node.right));
            }
        }
        return result;
    }

    class NodeWrapper {
        TreeNode node;

        NodeWrapper() {
        }

        NodeWrapper(TreeNode treeNode) {
            node = treeNode;
        }
    }
}

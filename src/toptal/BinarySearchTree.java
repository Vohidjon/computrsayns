//package toptal;
//
//import sun.plugin.dom.exception.InvalidStateException;
//
//public class BinarySearchTree {
//    public static void main(String[] args) {
//        SearchTree t = new SearchTree();
//        assert t.getNodeCount() == 0;
//        assert t.getHeight() == 0;
//        t.insert(5);
//        assert t.getNodeCount() == 1;
//        assert t.getHeight() == 1;
//        assert t.isInTree(5);
//        assert t.getMin() == t.getMax();
//        assert t.getMax() == 5;
//        t.insert(6);
//        assert t.getSuccessor(5) == 6;
//        t.deleteTree();
//        assert t.getNodeCount() == 0;
//        assert t.getHeight() == 0;
//        t.insert(1);
//        t.insert(-4);
//        t.insert(5);
//        t.printValues();
//        assert t.getHeight() == 2;
//        assert t.isBinarySearchTree();
//        t.deleteValue(1);
//        assert t.getNodeCount() == 2;
//        t.insert(7);
//        t.insert(100);
//        t.insert(90);
//        t.insert(88);
//        t.insert(7);
//        t.insert(17);
//        t.insert(15);
//        t.insert(1150);
//        t.insert(67);
//        t.insert(82);
//        t.insert(56);
//        t.insert(51);
//        t.insert(55);
//        t.insert(12);
//        assert t.isBinarySearchTree();
//        System.out.println();
//        t.printValues();
//    }
//}
//
//class SearchTree {
//    private TreeNode root;
//
//    public void insert(int key) {
//        TreeNode newNode = new TreeNode(key);
//        if(root == null) {
//            root = newNode;
//            return;
//        }
//        TreeNode parent = find(key, root);
//        if(key < parent.key) {
//            parent.left = newNode;
//        } else {
//            parent.right = newNode;
//        }
//    }
//
//    public int getNodeCount() {
//        return getNodeCount0(root);
//    }
//
//    public void printValues() {
//        printValues0(root);
//    }
//
//    private void printValues0(TreeNode node) {
//        if(node == null) return;
//        printValues0(node.left);
//        System.out.print(node.key + " | ");
//        printValues0(node.right);
//    }
//
//    public void deleteTree() {
//        root = null;
//    }
//
//    public boolean isInTree(int key) {
//        if(root == null) return false;
//
//        return find(key, root).key == key;
//    }
//
//    public int getHeight() {
//        return getHeight0(root);
//    }
//
//    private int getHeight0(TreeNode node) {
//        if(node == null) return 0;
//
//        return 1 + Math.max(getHeight0(node.left), getHeight0(node.right));
//    }
//
//    public int getMin() {
//        if(root == null) throw new InvalidStateException("Tree is empty");
//
//        TreeNode node = root;
//        while (node.left != null) node = node.left;
//        return node.key;
//    }
//
//    public int getMax() {
//        if(root == null) throw new InvalidStateException("Tree is empty");
//
//        TreeNode node = root;
//        while (node.right != null) node = node.right;
//        return node.key;
//    }
//
//    public boolean isBinarySearchTree() {
//        return isBinarySearchTree0(root);
//    }
//
//    private boolean isBinarySearchTree0(TreeNode node) {
//        if(node == null) return true;
//        if(node.left != null && node.left.key > node.key) return false;
//        if(node.right != null && node.right.key < node.key) return false;
//        return isBinarySearchTree0(node.left) && isBinarySearchTree0(node.right);
//    }
//
//    public void deleteValue(int key) {
//        if(root == null) return;
//        root = deleteValue0(key, root);
//    }
//
//    private TreeNode deleteValue0(int key, TreeNode node) {
//        if(key == node.key) {
//            if(node.left != null && node.right != null) {
//                TreeNode next = next(node);
//                node.key = next.key;
//                node.right = deleteValue0(next.key, node.right);
//                return node;
//            } else if(node.left != null){
//                return node.left;
//            } else if(node.right != null) {
//                return node.right;
//            } else {
//                return null;
//            }
//        } else if(key < node.key) {
//            node.left = deleteValue0(key, node.left);
//        } else {
//            node.right = deleteValue0(key, node.right);
//        }
//
//        return node;
//    }
//
//    public int getSuccessor(int key) {
//        if(root == null) return -1;
//        TreeNode node = find(key, root);
//        TreeNode next = next(node);
//        return next != null ? next.key : -1;
//    }
//
//    private TreeNode next(TreeNode node) {
//        if(node.right == null) return null;
//
//        node = node.right;
//        while (node.left != null) node = node.left;
//        return node;
//    }
//
//    private int getNodeCount0(TreeNode node) {
//        if(node == null) return 0;
//        return getNodeCount0(node.left) + 1 + getNodeCount0(node.right);
//    }
//
//    private TreeNode find(int key, TreeNode node) {
//        if(node.key == key) return node;
//
//        if(key < node.key) {
//            if(node.left == null) return node;
//            return find(key, node.left);
//        } else {
//            if(node.right == null) return node;
//            return find(key, node.right);
//        }
//    }
//}
//
//class TreeNode {
//    public TreeNode left;
//    public TreeNode right;
//    public int key;
//
//    public TreeNode(int key){
//        this.key = key;
//    }
//
//    public TreeNode(int key, TreeNode left, TreeNode right) {
//        this.key = key;
//        this.left = left;
//        this.right = right;
//    }
//}

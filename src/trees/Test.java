package trees;

public class Test {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        assert tree.getNodeCount() == 0 : "Tree should initially be empty";
        tree.insert(11);
        tree.insert(7);
        tree.insert(5);
        tree.insert(6);
        tree.insert(12);
        tree.insert(8);
        assert tree.getNodeCount() == 6 : "Tree should have 6 nodes";
        tree.printValues();
        assert tree.getHeight() == 4 : "Tree should have a height of 4";
        tree.deleteTree();
        assert tree.getNodeCount() == 0 : "Tree should be empty after deleting";
        tree.insert(9);
        tree.insert(10);
        tree.insert(8);
        tree.insert(4);
        tree.insert(5);
        assert tree.isInTree(5) == true: "Should be in tree";
        assert tree.isInTree(13) == false : "Should not be in tree";
        assert tree.getMin() == 4 : "Min value should be 4";
        assert tree.getMax() == 10 : "Max value should be 10";
        assert tree.isBinarySearchTree() == true : "Should be a BST";

        tree.deleteTree();
        tree.insert(11);
        tree.insert(7);
        tree.insert(5);
        tree.insert(6);
        tree.insert(12);
        tree.insert(8);
        tree.deleteValue(7);
        assert tree.getNodeCount() == 5 : "Tree should have 5 nodes";
        tree.printValues();

        assert tree.getSuccessor(6) == 8 : "Successor should be 8";
        assert tree.getSuccessor(12) == -1 : "Successor should be -1, i.e no successor";

    }
}

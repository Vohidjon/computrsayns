package trees;

import java.util.Arrays;

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


        MaxHeap heap = new MaxHeap();
        assert heap.isEmpty() : "Should initially be empty";
        heap.insert(6);
        assert heap.getSize() == 1 : "Size should be 1";
        heap.insert(9);
        assert heap.getMax() == 9 : "Max should be 9";
        heap.extractMax();
        assert heap.getMax() == 6 : "Max should be 6";
        heap.insert(12);
        heap.insert(16);
        heap.insert(2);
        heap.insert(3);
        int oldSize = heap.getSize();
        heap.remove(16);
        assert heap.getSize() + 1 == oldSize : "Size should decrement";

        int[] array = new int[]{-1, 9, 7, 3, 5, 4, 8, 6, 2, 1};
        MaxHeap.heapSort(array);
        assert Arrays.equals(array, new int[]{-1, 1, 2, 3, 4, 5, 6, 7, 8, 9}) : "Should be sorted";

    }
}

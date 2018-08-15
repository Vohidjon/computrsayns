package trees;

public class BSTNode {
    int value;
    BSTNode left;
    BSTNode right;

    public BSTNode(int value) {
        this.value = value;
    }

    public BSTNode(int value, BSTNode left, BSTNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

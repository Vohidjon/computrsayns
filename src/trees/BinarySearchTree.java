package trees;

public class BinarySearchTree {
    private BSTNode root;

    public void insert(int value) {
        root = insert0(root, value);
    }

    /**
     * Time - O(h), where h is the height of the tree
     * Space - 0(1)
     *
     * @param node  node representing the root of the current tree/sub-tree
     * @param value value to be insert
     * @return the node passed as the 1st argument, or newly created node in case it is null
     */
    private BSTNode insert0(BSTNode node, int value) {
        if (node == null) node = new BSTNode(value);
        else if (node.value >= value)
            node.left = insert0(node.left, value);
        else
            node.right = insert0(node.right, value);

        return node;
    }

    public int getNodeCount() {
        return getNodeCount0(root);
    }

    /**
     * Time - O(n), meaning it should visit all nodes
     * Space - O(1)
     *
     * @param node node representing the root of the current tree/sub-tree
     * @return count of nodes in sub-tree @node
     */
    private int getNodeCount0(BSTNode node) {
        if (node == null) return 0;
        else return getNodeCount0(node.left) + getNodeCount0(node.right) + 1;
    }

    public void printValues() {
        printValues0(root);
        System.out.println();
    }

    /**
     * Time - O(n), meaning it should visit all nodes
     * Space - O(1)
     *
     * @param node node representing the root of the current tree/sub-tree
     */
    private void printValues0(BSTNode node) {
        if (node != null) {
            printValues0(node.left);
            System.out.print(node.value + ", ");
            printValues0(node.right);
        }
    }

    public void deleteTree() {
        root = null;
    }

    public boolean isInTree(int value) {
        return isInTree0(root, value);
    }

    /**
     * Time - O(h), where h is the height of the tree
     * Space - 0(1)
     *
     * @param node  node representing the root of the current tree/sub-tree
     * @param value value to be searched
     */
    private boolean isInTree0(BSTNode node, int value) {
        if (node == null) return false;

        if (node.value == value) return true;
        else if (node.value > value) return isInTree0(node.left, value);
        else return isInTree0(node.right, value);
    }

    public int getHeight() {
        return getHeight0(root);
    }

    /**
     * Time - O(n), meaning it should visit all nodes
     * Space - O(1)
     *
     * @param node node representing the root of the current tree/sub-tree
     */
    private int getHeight0(BSTNode node) {
        if (node == null) return 0;

        return Math.max(getHeight0(node.left), getHeight0(node.right)) + 1;
    }

    /**
     * Time - O(h), where h is the height of the tree
     * Space - 0(1)
     *
     * @return minimum value in the tree
     */
    public int getMin() {
        if (root == null) return -1;

        BSTNode temp = root;
        while (temp.left != null) temp = temp.left;
        return temp.value;
    }

    /**
     * Time - O(h), where h is the height of the tree
     * Space - 0(1)
     *
     * @return maximum value in the tree
     */
    public int getMax() {
        if (root == null) return -1;

        BSTNode temp = root;
        while (temp.right != null) temp = temp.right;
        return temp.value;
    }

    public boolean isBinarySearchTree() {
        return isBinarySearchTree0(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * Time - O(n), meaning it should visit all nodes
     * Space - O(1)
     *
     * @param node node representing the root of the current tree/sub-tree
     */
    private boolean isBinarySearchTree0(BSTNode node, int minValue, int maxValue) {
        if (node == null) return true;

        if (minValue <= node.value && node.value < maxValue)
            return isBinarySearchTree0(node.left, minValue, node.value) && isBinarySearchTree0(node.right, node.value, maxValue);
        return false;
    }

    public void deleteValue(int value) {
        root = deleteValue0(root, value);
    }

    /**
     * Time - O(h), where h is the height of the tree
     * Space - O(1)
     *
     * @param node node representing the root of the current tree/sub-tree
     */
    private BSTNode deleteValue0(BSTNode node, int value) {
        if(node == null) return null;

        if(node.value > value) node.left = deleteValue0(node.left, value);
        else if(node.value < value) node.right = deleteValue0(node.right, value);
        else { // found the item to delete
            if(node.left == null && node.right == null) return null; // case 1
            else if(node.right == null) node = node.left; // case 2
            else if(node.left == null) node = node.right; // case 2
            else { // case 3
                BSTNode minNode = node.right;
                while (minNode.left != null) {
                    minNode = minNode.left;
                }
                node.value = minNode.value;
                node.right = deleteValue0(node.right, minNode.value);
            }
        }
        return node;
    }

    /**
     * Time - O(h), where h is the height of the tree
     * Space - O(1)
     *
     * @param value
     */
    public int getSuccessor(int value) {
        BSTNode node = getNode(root, value);
        if(node == null) return -1;
        else if(node.right != null) {
            // find min in the right sub-tree
            BSTNode minNode = node.right;
            while (minNode.left != null) {
                minNode = minNode.left;
            }
            return minNode.value;
        } else {
            BSTNode successor = null;
            BSTNode ancestor = root;
            while (ancestor != node) {
                if(node.value < ancestor.value) {
                    successor = ancestor;
                    ancestor = ancestor.left;
                } else
                    ancestor = ancestor.right;
            }
            return successor == null ? -1 : successor.value;
        }
    }

    private BSTNode getNode(BSTNode node, int value) {
        if (node == null) return null;

        if (node.value == value) return node;
        else if (node.value > value) return getNode(node.left, value);
        else return getNode(node.right, value);
    }
}
package trees;

public class MaxHeap {
    private int size = 0;
    private int[] heap = new int[16];

    /**
     * Time - O(lg(n))
     * @param value
     */
    public void insert(int value) {
        this.heap[++size] = value;
        this.siftUp(size);
    }

    /**
     * Time - O(1)
     * @return
     */
    public int getMax() {
        return this.heap[1];
    }

    /**
     * Time - O(1)
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * Time - O(1)
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Time - O(lg(n))
     * @return
     */
    public int extractMax() {
        int max = this.heap[1];
        this.heap[1] = this.heap[size];
        size--;
        siftDown(1);
        return max;
    }


    /**
     * Time - O(lg(n))
     * @return
     */
    public void remove(int value) {
        int index = indexOf(1, value);
        if(index == -1) return;

        this.heap[index] = Integer.MAX_VALUE;
        siftUp(index);
        extractMax();
    }

    /**
     * Time - O(lg(n)), visits all n nodes at worst case
     * @return
     */
    private int indexOf(int root, int value) {
        if(root > size) return -1;
        if(this.heap[root] == value) return root;
        return Math.max(indexOf(leftChild(root), value), indexOf(rightChild(root), value));
    }

    /**
     * Time - O(n)
     * @param array
     */
    private static void heapify(int[] array) {
        int size = array.length - 1;
        for(int i = size / 2; i > 0; i--) {
            siftDown(array, size, i);
        }
    }

    /**
     * Time - O(nlg(n))
     * @param array
     */
    public static void heapSort(int[] array) {
        heapify(array);
        int size = array.length - 1;
        while (size > 0) {
            int temp = array[size];
            array[size] = array[1];
            array[1] = temp;
            size--;
            siftDown(array, size, 1);
        }
    }
    /**
     * Time - O(lg(n))
     * @param position
     */
    private void siftUp(int position) {
        int parentPosition = parent(position);
        if(parentPosition > 0 && this.heap[position] > this.heap[parentPosition]) {
            int temp = this.heap[position];
            this.heap[position] = this.heap[parentPosition];
            this.heap[parentPosition] = temp;
            this.siftUp(parentPosition);
        }
    }

    /**
     * Time - O(lg(n))
     * @param position
     */
    private void siftDown(int position) {
        int leftChildPosition = leftChild(position);
        int rightChildPosition = rightChild(position);
        int max = position;
        if(leftChildPosition <= size && this.heap[max] < this.heap[leftChildPosition]) {
            max = leftChildPosition;
        }
        if(rightChildPosition <= size && this.heap[max] < this.heap[rightChildPosition]) {
            max = rightChildPosition;
        }
        if(max != position) {
            int temp = this.heap[position];
            this.heap[position] = this.heap[max];
            this.heap[max] = temp;
            siftDown(max);
        }
    }

    /**
     * Time - O(lg(n))
     * @param position
     */
    private static void siftDown(int[] array, int size, int position) {
        int leftChildPosition = leftChild(position);
        int rightChildPosition = rightChild(position);
        int max = position;
        if(leftChildPosition <= size && array[max] < array[leftChildPosition]) {
            max = leftChildPosition;
        }
        if(rightChildPosition <= size && array[max] < array[rightChildPosition]) {
            max = rightChildPosition;
        }
        if(max != position) {
            int temp = array[position];
            array[position] = array[max];
            array[max] = temp;
            siftDown(array, size, max);
        }
    }

    private int parent(int position) {
        return position / 2;
    }

    private static int leftChild(int position) {
        return position * 2;
    }

    private static int rightChild(int position) {
        return position * 2 + 1;
    }
}

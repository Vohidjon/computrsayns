package toptal;

public class Heaps {
    public static void main(String[] args) {
        MaxHeap mh = new MaxHeap();
        assert mh.getSize() == 0;
        assert mh.isEmpty();
        mh.insert(1);
        assert mh.getSize() == 1;
        assert mh.getMax() == 1;
        assert mh.extractMax() == 1;
        assert mh.getSize() == 0;
        assert mh.isEmpty();
        mh.insert(1);
        mh.insert(2);
        mh.insert(3);
        mh.insert(4);
        mh.insert(5);
        mh.insert(6);
        assert mh.getSize() == 6;
        assert mh.getMax() == 6;
        mh.remove(0);
        mh.remove(0);
        mh.remove(0);
        mh.remove(0);
        mh.remove(0);
        mh.remove(0);
        assert mh.getSize() == 0;
        assert mh.isEmpty();
        mh = new MaxHeap(new int[]{4, 5, 43, 5, 23, 11});
        assert mh.getMax() == 43;
        int[] arr = new int[] {3, 5, 0, -1, 99, 2};
        MaxHeap.heapSort(arr);
        assert arr[0] == -1;
        assert arr[1] == 0;
        assert arr[5] == 99;
    }
}

class MaxHeap {
    private int size;
    private int[] heap;

    public MaxHeap() {
        heap = new int[16];
        size = 0;
    }

    public MaxHeap(int[] arr) {
        heap = arr;
        size = arr.length;
        heapify();
    }

    public void insert(int key) {
        heap[size++] = key;
        siftUp(size);
    }

    public int getMax() {
        if(size == 0) throw new IllegalStateException("No items in the heap");

        return heap[0];
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int extractMax() {
        if(size == 0) throw new IllegalStateException("No items in the heap");

        int max = heap[0];
        size--;

        if(size > 0) {
            heap[0] = heap[size];
            siftDown(1);
        }

        return max;
    }


    private void siftUp(int pos) {
        int parent = parent(pos);
        if(pos > 0 && parent > 0 && heap[pos - 1] > heap[parent - 1]) {
            int temp = heap[pos - 1];
            heap[pos - 1] = heap[parent - 1];
            heap[parent - 1] = temp;
            siftUp(parent);
        }
    }

    private void siftDown(int pos) {
        int left = leftChild(pos);
        int right = rightChild(pos);

        if((left <= size && heap[pos - 1] < heap[left - 1]) || (right <= size && heap[pos - 1] < heap[right - 1])) {
            int maxPos = left;
            if(right <= size && heap[maxPos - 1] < heap[right - 1]) {
                maxPos = right;
            }
            int temp = heap[pos - 1];
            heap[pos - 1] = heap[maxPos - 1];
            heap[maxPos - 1] = temp;
            siftDown(maxPos);
        }
    }

    public void remove(int idx) {
        if(idx >= size) throw new IllegalStateException("No item at this position");

        int deleted = heap[idx];
        heap[idx] = heap[size - 1];
        size--;
        if(heap[idx] < deleted) {
            siftDown(idx + 1);
        } else if(heap[idx] > deleted) {
            siftUp(idx + 1);
        }
    }

    private void heapify() {
        for (int i = size ; i > 0 ; i--) {
            siftDown(i);
        }
    }

    public static void heapSort(int[] arr) {
        MaxHeap heap = new MaxHeap(arr);
        for (int i = 0; i < arr.length; i++) {
            arr[arr.length - i - 1] = heap.extractMax();
        }
    }

    private int leftChild(int pos) { return pos * 2; }

    private int rightChild(int pos) { return pos * 2 + 1; }

    private int parent(int pos) { return pos / 2; }
}

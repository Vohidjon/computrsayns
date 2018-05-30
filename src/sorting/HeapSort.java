package sorting;

import trees.MaxHeap;

public class HeapSort extends BaseSort {
    /**
     * Time - O(nlg(n))
     *
     * @param array
     */
    public static void sort(int[] array) {
        MaxHeap.heapSort(array);
    }
}

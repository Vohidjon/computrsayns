package sorting;

import trees.MaxHeap;

public class HeapSort extends BaseSort {
    /**
     * Stable - NO
     * Time - O(nlg(n))
     *
     * @param array
     */
    public static void sort(int[] array) {
        MaxHeap.heapSort(array);
    }
}

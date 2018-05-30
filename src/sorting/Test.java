package sorting;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] unsortedArr = new int[]{3, 34, 5, 56, 7, 38, 33, 10, 41, 13, 33, 100};
        int[] sortedArr = new int[]{3, 5, 7, 10, 13, 33, 33, 34, 38, 41, 56, 100};

        int[] byBubbleSort = Arrays.copyOf(unsortedArr, unsortedArr.length);
        BubbleSort.sort(byBubbleSort);
        assert Arrays.equals(byBubbleSort, sortedArr);

        int[] byInsertionSort = Arrays.copyOf(unsortedArr, unsortedArr.length);
        InsertionSort.sort(byInsertionSort);
        assert Arrays.equals(byInsertionSort, sortedArr);

        int[] bySelectionSort = Arrays.copyOf(unsortedArr, unsortedArr.length);
        SelectionSort.sort(bySelectionSort);
        assert Arrays.equals(bySelectionSort, sortedArr);

        int[] byHeapSort = Arrays.copyOf(unsortedArr, unsortedArr.length);
        HeapSort.sort(byHeapSort);
        assert Arrays.equals(byHeapSort, sortedArr);

        int[] byMergeSort = Arrays.copyOf(unsortedArr, unsortedArr.length);
        MergeSort.sort(byMergeSort);
        assert Arrays.equals(byMergeSort, sortedArr);

    }
}

package sorting;

public class SelectionSort extends BaseSort {
    /**
     * Time - O(n^2)
     * @param array
     */
    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[min] > array[j]) min = j;
            }
            exchange(array, i, min);
        }
    }
}

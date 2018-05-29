package sorting;

public class InsertionSort extends BaseSort {
    /**
     * Time - O(n^2)
     * @param array
     */
    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if(array[j] >= array[j - 1]) {
                    break;
                }
                exchange(array, j, j - 1);
            }
        }
    }
}

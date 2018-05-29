package sorting;

public class BubbleSort extends BaseSort{
    /**
     * Time - O(n^2), works quite fast when n <= 16
     *
     * @param array
     */
    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    exchange(array, j, j + 1);
                }
            }
        }
    }
}

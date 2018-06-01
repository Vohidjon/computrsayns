package sorting;

public class CountingSort {

    /**
     * Applicable only if the keys have no associated values
     * Time - O(n)
     * @param array
     * @param maxKey
     */
    public static void sort(int[] array, int maxKey) {
        int[] counts = new int[maxKey + 1];

        for (int i = 0; i < array.length; i++) counts[array[i]]++;

        int k = 0;
        for (int i = 0; i < counts.length; i++) {
            for (int j = 0; j < counts[i]; j++) {
                array[k++] = i;
            }
        }
    }
}

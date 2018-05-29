package sorting;

public class BaseSort {
    /**
     * Simply exchanges the values at indices a and b
     * @param array
     * @param a
     * @param b
     */
    public static void exchange(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}

package sorting;


public class MergeSort {
    /**
     * Time - O(nlg(n))
     * @param array
     */
    public static void sort(int[] array) {
        int[] aux = new int[array.length];
        sort(array, aux, 0, array.length - 1);
    }

    private static void sort(int[] array, int[] aux, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        sort(array, aux, lo, mid); // sort left sub-array
        sort(array, aux, mid + 1, hi); // sort right sub-array
        merge(array, aux, lo, mid, hi);
    }

    /**
     * Time - O(n)
     * @param array
     * @param aux
     * @param lo
     * @param mid
     * @param hi
     */
    private static void merge(int[] array, int[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = array[k];
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) array[k] = aux[j++];
            else if (j > hi) array[k] = aux[i++];
            else if (less(aux[j], aux[i])) array[k] = aux[j++];
            else array[k] = aux[i++];
        }
    }

    private static boolean less(int a, int b) {
        return a < b;
    }
}

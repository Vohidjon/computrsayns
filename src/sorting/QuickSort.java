package sorting;

public class QuickSort extends BaseSort {
    /**
     * Average Case - O(nlog(n))
     * Worst Case - O(n^2)
     * @param array
     */
    public static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int lo, int hi) {
        if(lo >= hi) return;
        int v = partition(array, lo, hi);
        sort(array, lo, v - 1);
        sort(array, v + 1, hi);
    }

    /**
     * Time - O(n)
     * @param array
     * @param lo
     * @param hi
     * @return
     */
    private static int partition(int[] array, int lo, int hi) {
        int i = lo, j = hi + 1;
        while (true) {

            while (array[++i] < array[lo]) {
                if(i == hi) break;
            }

            while (array[--j] > array[lo]) {
                if(j == lo) break;
            }

            if(i >= j) break;
            exchange(array, i, j);
        }
        exchange(array, lo, j);
        return j;
    }
}

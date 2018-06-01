package sorting;


public class CountingAdvancedSort {
    public static void sort(int[] array, int maxKey) {
        int[] counts = new int[maxKey + 1];
        for (int i = 0; i < array.length; i++) {
            counts[array[i]]++;
        }
        int total = 0;
        for (int i = 0; i < counts.length; i++) {
            int c = counts[i];
            counts[i] = total;
            total = total + c;
        }
        int[] output = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            output[counts[array[i]]++] = array[i];
        }
        for (int i = 0; i < output.length; i++) {
            array[i] = output[i];
        }
    }
}

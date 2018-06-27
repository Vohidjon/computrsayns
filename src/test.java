public class test {
    int hasNValues(int[] a, int n) {
        if (a.length < n) return 0; // no need to go further if # of elements in array is less than n

        // array of 0s and 1s
        // zero means current element is new
        // one means current element was recorded before
        // all elements initially have zero
        int[] mappings = new int[a.length];

        int countOfUnique = 0;
        for (int i = 0; i < a.length; i++) {
            if(mappings[i] == 0) {
                mappings[i] = 1;
                countOfUnique++;
                for (int j = i + 1; j < a.length; j++) {
                    if(a[i] == a[j]) mappings[j] = 1;
                }
            }
        }
        return countOfUnique == n ? 1 : 0;
    }

    int isPairedN(int[] a, int n) {
        if (2 * a.length - 3 < n // max possible sum of indexes must be greater or equal to n (higher bound)
                || 1 > n // n must be greater or equal to 1 (lower bound)
                || a.length < 2 // array should contain at least 2 elements
                ) return 0;

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (i + j == n && a[i] + a[j] == n) return 1;

                // break inner loop if sum of i and j is already more than n
                if (i + j >= n) break;
            }

            // break loop if i is already more than n
            if (i >= n) break;
        }
        return 0;
    }

    int isOnionArray(int[] a) {
        for (int j = 0; j < a.length / 2; j++) {
            int k = a.length - j - 1;
            if(a[j] + a[k] > 10) return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        test t = new test();
        System.out.println(t.hasNValues(new int[]{1, 2, 2, 1}, 2));
        System.out.println(t.hasNValues(new int[]{1, 1, 1, 8, 1, 1, 1, 3, 3}, 3));
        System.out.println(t.hasNValues(new int[]{1, 2, 3, 4, 5, 6, 7, 8 ,9, 10}, 10));
        System.out.println(t.hasNValues(new int[]{1, 2, 2, 1}, 3));
        System.out.println(t.hasNValues(new int[]{1, 1, 1, 8, 1, 1, 1, 3, 3}, 2));
        System.out.println(t.hasNValues(new int[]{1, 2, 3, 4, 5, 6, 7, 8 ,9, 10}, 20));
        System.out.println("-----------------------------------------------");
        System.out.println(t.isPairedN(new int[] {1, 4, 1, 4, 5, 6}, 5));
        System.out.println(t.isPairedN(new int[] {1, 4, 1, 4, 5, 6}, 6));
        System.out.println(t.isPairedN(new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8}, 6));
        System.out.println(t.isPairedN(new int[] {1, 4, 1}, 5));
        System.out.println(t.isPairedN(new int[] {8, 8, 8, 8, 7, 7, 7}, 15));
        System.out.println(t.isPairedN(new int[] {8, -8, 8, 8, 7, 7, -7}, -15));
        System.out.println(t.isPairedN(new int[] {3}, 3));
        System.out.println(t.isPairedN(new int[] {}, 0));
        System.out.println("-----------------------------------------------");
        System.out.println(t.isOnionArray(new int[]{1, 2, 19, 4, 5}));
        System.out.println(t.isOnionArray(new int[]{1, 2, 3, 4, 15}));
        System.out.println(t.isOnionArray(new int[]{1, 3, 9, 8}));
        System.out.println(t.isOnionArray(new int[]{2}));
        System.out.println(t.isOnionArray(new int[]{}));
        System.out.println(t.isOnionArray(new int[]{-2, 5, 0, 5, 12}));

    }
}

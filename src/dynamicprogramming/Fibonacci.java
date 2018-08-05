package dynamicprogramming;

public class Fibonacci {
    /**
     * Time - O(n)
     * Space - O(n)
     * @param n
     * @return
     */
    public int nThFibonacci(int n) {
        if(n == 1 || n == 2) return 1;
        int[] fibs = new int[n];
        fibs[0] = fibs[1] = 1;
        for (int i = 2; i < n; i++) {
            fibs[i] = fibs[i - 1] + fibs[i - 2];
        }
        return fibs[n - 1];
    }
}

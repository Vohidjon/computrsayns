package dynamicprogramming;


public class Test {
    public static void main(String[] args) {
        int[][] matrices = {
                {2, 3},
                {3, 6},
                {6, 4},
                {4, 5}
        };
        System.out.println(new MatrixChainMultiplication().minCostResults(matrices));
    }
}

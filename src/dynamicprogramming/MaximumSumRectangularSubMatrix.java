package dynamicprogramming;

import common.Kadane;

public class MaximumSumRectangularSubMatrix {
    private static final int SUM = 0;
    private static final int LEFT = 1;
    private static final int RIGHT = 2;
    private static final int UP = 3;
    private static final int DOWN = 4;

    public int maxSum(int[][] matrix) {
        int[] results = computeResults(matrix);
        return results[SUM];
    }

    public int[][] maxSubMatrix(int[][] matrix) {
        int[] results = computeResults(matrix);
        int[][] subMatrix = new int[results[DOWN] - results[UP] + 1][results[RIGHT] - results[LEFT] + 1];

        for (int i = results[UP]; i <= results[DOWN]; i++) {
            for (int j = results[LEFT]; j <= results[RIGHT]; j++) {
                subMatrix[i - results[UP]][j - results[LEFT]] = matrix[i][j];
            }
        }
        return subMatrix;
    }

    private int[] computeResults(int[][] matrix) {
        int[] arr = new int[matrix.length];
        int maxSum = Integer.MIN_VALUE;
        int maxLeft = -1,
                maxRight = -1,
                maxUp = -1,
                maxDown = -1;
        Kadane kadane = new Kadane();
        for (int L = 0; L < matrix[0].length; L++) {
            for (int i = 0; i < matrix.length; i++) arr[i] = 0;
            for (int R = L; R < matrix[0].length; R++) {
                for (int i = 0; i < matrix.length; i++) {
                    arr[i] += matrix[i][R];
                }

                int[] results = kadane.maxSumContiguousSubArray(arr);
                if (maxSum < results[Kadane.SUM]) {
                    maxSum = results[Kadane.SUM];
                    maxLeft = L;
                    maxRight = R;
                    maxUp = results[Kadane.START];
                    maxDown = results[Kadane.END];
                }
            }
        }
        return new int[]{maxSum, maxLeft, maxRight, maxUp, maxDown};
    }
}

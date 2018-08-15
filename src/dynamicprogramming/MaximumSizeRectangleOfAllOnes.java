package dynamicprogramming;

import stacks.MaximumHistogram;

public class MaximumSizeRectangleOfAllOnes {
    public int max(int[][] matrix) {
        if(matrix.length == 0) return 0;
        int[] arr = new int[matrix[0].length];
        int maxArea = Integer.MIN_VALUE;
        MaximumHistogram maxHis = new MaximumHistogram();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) arr[j] = 0;
                else arr[i]++;
            }

            int area = maxHis.maxHistogram(arr);
            if(maxArea < area) maxArea = area;
        }

        return maxArea;
    }
}

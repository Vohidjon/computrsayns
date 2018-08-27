package leetcode.medium;

import java.util.Deque;
import java.util.LinkedList;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int[] arr = new int[matrix[0].length];
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '0') arr[j] = 0;
                else arr[j]++;
            }

            int area = maxHistogram(arr);
            if (maxArea < area) maxArea = area;
        }

        return maxArea;
    }

    public int maxHistogram(int input[]) {
        Deque<Integer> stack = new LinkedList<Integer>();
        int maxArea = 0;
        int area = 0;
        int i;
        for (i = 0; i < input.length; ) {
            if (stack.isEmpty() || input[stack.peekFirst()] <= input[i]) {
                stack.offerFirst(i++);
            } else {
                int top = stack.pollFirst();
                if (stack.isEmpty()) {
                    int min = Math.min(input[top], i);
                    area = min * min;
                } else {
                    int min = Math.min(input[top], (i - stack.peekFirst() - 1));
                    area = min * min;
                }
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        while (!stack.isEmpty()) {
            int top = stack.pollFirst();
            if (stack.isEmpty()) {
                int min = Math.min(input[top], i);
                area = min * min;
            } else {
                int min = Math.min(input[top], (i - stack.peekFirst() - 1));
                area = min * min;
            }
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }
}

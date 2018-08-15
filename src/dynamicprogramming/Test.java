package dynamicprogramming;


public class Test {
    public static void main(String[] args) {
        int[][] input = new int[][]{
                { 2,  1, -3, -4,  5},
                { 0,  6,  3,  4,  1},
                { 2, -2, -1,  4, -5},
                {-3,  3,  1,  0,  3}};
        int[][] a = new MaximumSumRectangularSubMatrix().maxSubMatrix(input);
    }
}

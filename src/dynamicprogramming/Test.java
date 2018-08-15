package dynamicprogramming;

public class Test {
    public static void main(String[] args) {
        int[][] input = new int[][]{
                {1, 0, 0, 1, 1, 1},
                {1, 0, 1, 1, 0, 1},
                {0, 1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1}};
        System.out.println(new MaximumSizeRectangleOfAllOnes().max(input));
    }
}

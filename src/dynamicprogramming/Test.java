package dynamicprogramming;

public class Test {
    public static void main(String[] args) {
        System.out.println(new BoxStackingProblem().stack(new int[][]{
                new int[]{1, 2, 4},
                new int[]{3, 2, 5},
        }));
    }
}

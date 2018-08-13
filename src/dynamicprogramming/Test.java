package dynamicprogramming;

public class Test {
    public static void main(String[] args) {
        System.out.println(new JobSchedulingProblem().pickJobs(
                new int[]{1, 2, 4, 6, 5, 7},
                new int[]{3, 5, 6, 7, 8, 9},
                new int[]{5, 6, 5, 4, 11, 2}));
    }
}

package leetcode.medium;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n <= 2) return n;
        int[] DP = new int[n];
        DP[0] = 1;
        DP[1] = 2;
        for (int i = 2; i < n; i++) {
            DP[i] = DP[i - 1] + DP[i - 2];
        }
        return DP[n - 1];
    }
}

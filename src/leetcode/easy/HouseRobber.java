package leetcode.easy;

public class HouseRobber {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        int[] DP = new int[nums.length + 1];
        DP[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) DP[i] = Math.max(DP[i - 1], DP[i - 2] + nums[i - 1]);
        return DP[nums.length];
    }
}

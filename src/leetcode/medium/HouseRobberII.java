package leetcode.medium;

public class HouseRobberII {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int[] DPRobs1st = new int[nums.length + 1];
        DPRobs1st[1] = nums[0];
        int[] DPDoesntRobs1st = new int[nums.length + 1];
        DPDoesntRobs1st[1] = 0;
        for (int i = 2; i < nums.length; i++) DPRobs1st[i] = Math.max(DPRobs1st[i - 1], DPRobs1st[i - 2] + nums[i - 1]);
        DPRobs1st[nums.length] = DPRobs1st[nums.length - 1];
        for (int i = 2; i <= nums.length; i++) DPDoesntRobs1st[i] = Math.max(DPDoesntRobs1st[i - 1], DPDoesntRobs1st[i - 2] + nums[i - 1]);
        return Math.max(DPRobs1st[nums.length], DPDoesntRobs1st[nums.length]);
    }

}

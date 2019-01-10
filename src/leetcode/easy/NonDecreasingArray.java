package leetcode.easy;

public class NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        boolean changed = false;
        int previous = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < previous && changed) {
                return false;
            } else {
                nums[i] = previous;
                changed = true;
            }
            previous = nums[i];
        }
        return true;
    }
}

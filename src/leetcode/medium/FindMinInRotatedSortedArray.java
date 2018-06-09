package leetcode.medium;

public class FindMinInRotatedSortedArray {
    public static int findMin(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int prev = (i - 1 + nums.length) % nums.length;
            int next = i + 1 % nums.length;
            if (nums[(i - 1 + nums.length) % nums.length] >= nums[i] && nums[i] <= nums[(i + 1) % nums.length])
                return nums[i];
        }
        throw new IllegalArgumentException();
    }
}

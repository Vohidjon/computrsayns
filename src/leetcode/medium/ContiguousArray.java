package leetcode.medium;

import java.util.Arrays;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        int max = 0;
        int[] maxes = new int[nums.length * 2 + 1];
        Arrays.fill(maxes, -2);
        maxes[nums.length] = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            if(maxes[count + nums.length] >= -1) {
                max = Math.max(max, i - maxes[count + nums.length]);
            } else {
                maxes[count + nums.length] = i;
            }
        }
        return max;
    }
}

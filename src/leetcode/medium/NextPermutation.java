package leetcode.medium;

public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        int switchIndex = nums.length - 1;
        for (; switchIndex > 0; switchIndex--) {
            if(nums[switchIndex] > nums[switchIndex - 1]) {
                int min = switchIndex;
                for (int i = switchIndex + 1; i < nums.length; i++) {
                    if(nums[i] <= nums[min] && nums[i] > nums[switchIndex - 1]) min = i;
                }
                int temp = nums[switchIndex - 1];
                nums[switchIndex - 1] = nums[min];
                nums[min] = temp;
                break;
            }
        }

        int start = switchIndex, end = nums.length - 1;
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

package leetcode.medium;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0 || (nums.length == 1 && nums[0] != target)) return new int[]{-1, -1};
        double targetA = target - 0.5;
        double targetB = target + 0.5;
        int firstPos = -1;
        int lastPos = -1;
        int min = 0;
        int max = nums.length - 1;
        if(nums[0] == target) {
            firstPos = 0;
        } else {
            while (min + 1 < max) {
                int mid = min + (max - min) / 2 + (max - min) % 2;
                if (nums[mid] < targetA) {
                    min = mid;
                } else {
                    max = mid;
                }
            }
            firstPos = max;
        }
        min = 0;
        max = nums.length - 1;
        if(nums[nums.length - 1] == target) {
            lastPos = nums.length - 1;
        } else {
            while (min + 1 < max) {
                int mid = min + (max - min) / 2 + (max - min) % 2;
                if (targetB < nums[mid]) {
                    max = mid;
                } else {
                    min = mid;
                }
            }
            lastPos = min;
        }
        if(firstPos <= lastPos) return new int[]{firstPos, lastPos};
        else return new int[]{-1, -1};
    }
}

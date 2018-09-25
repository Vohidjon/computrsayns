package leetcode.medium;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        // find rotation point
        int rPoint = 0;
        int min = 0;
        int max = nums.length - 1;
        while (min + 1 < max) {
            int half = (min + max) / 2;
            if(nums[min] < nums[half]) {
                min = half;
            }
            if(nums[half] < nums[max]) {
                max = half;
            }
        }
        if(nums[min] > nums[max]) {
            rPoint = max;
        }
        if(rPoint == 0) {
            min = 0;
            max = nums.length - 1;
        } else if(nums[0] <= target && target <= nums[rPoint - 1]) {
            min = 0;
            max = rPoint - 1;
        } else if(nums[rPoint] <= target && target <= nums[nums.length - 1]) {
            min = rPoint;
            max = nums.length - 1;
        } else return -1;

        while (min <= max) {
            int mid = min + (max - min) / 2 + (max - min) % 2;
            if (nums[mid] > target) {
                max = mid - 1;
            } else if (nums[mid] < target) {
                min = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}

package leetcode.hard;

/**
 * Incomplete
 */
public class MedianOfTwoSortedArrays {
    public static double median(int[] nums1, int[] nums2) {
        if(nums1.length % 2 == 1) {
            int middleA = nums2.length / 2;
            int middleB = nums2.length / 2 + nums2.length % 2;
            int point = findInsertionPoint(nums1[nums1.length / 2], nums2);
            return point;
        }
        return 1;
    }

    public static int findInsertionPoint(int value, int[] arr) {
        int min = 0;
        int max = arr.length - 1;
        while (min <= max) {
            int mid = min + (max - min) / 2 + (max - min) % 2;
            if (arr[mid] > value) {
                max = mid - 1;
            } else if (arr[mid] < value) {
                min = mid + 1;
            } else {
                return mid;
            }
        }
        return min;
    }
}

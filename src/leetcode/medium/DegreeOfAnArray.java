package leetcode.medium;

import java.util.HashMap;

public class DegreeOfAnArray {
    public int findShortestSubArray(int[] nums) {
        int maxDegree = 0;
        int length = 0;
        HashMap<Integer, Integer> degrees = new HashMap<>();
        HashMap<Integer, Integer> starts = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int degree = 1;
            int start = i;
            if (degrees.containsKey(nums[i])) {
                start = starts.get(nums[i]);
                degree = degrees.get(nums[i]) + 1;
                degrees.put(nums[i], degree);
            } else {
                degrees.put(nums[i], degree);
                starts.put(nums[i], i);
            }
            if (maxDegree < degree || (maxDegree == degree && i - start + 1 < length)) {
                maxDegree = degree;
                length = i - start + 1;
            }
        }
        return length;
    }
}

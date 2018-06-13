package leetcode.medium;

public class ContainerWithMostWater {
    /**
     * Brute-force solution
     * Time - O(n^2)
     * Space - O(1)
     * @param height
     * @return
     */
    public static int maxAreaBruteForce(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                if(area > max) max = area;
            }
        }
        return max;
    }

    /**
     * Two-pointer solution
     * Time - O(n)
     * Space - O(1)
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int max = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            max = Math.max(max, (r - l) * Math.min(height[l], height[r]));
            if(height[l] > height[r]) r--;
            else l++;
        }
        return max;
    }
}

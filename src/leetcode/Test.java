package leetcode;


import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        new Test().maxPoints(new int[][]{{1, 1}, {1, 1}, {3, 3}});
    }

    public int maxPoints(int[][] points) {
        int res = 0;
        for(int[] p1 : points) {
            Map<Float, Integer> m = new HashMap<>();
            int max = 0;
            for(int[] p2 : points) {
                if(p1 == p2) continue;
                float slope = this.calcSlope(p1, p2);
                int c = m.getOrDefault(slope, 0) + 1;
                max = Math.max(max, c);
                m.put(slope, c);
            }
            res = Math.max(res, max);
        }
        return res + 1;
    }

    private float calcSlope(int[] p1, int[] p2) {
        return ((float)(p1[1] - p2[1])) / (p1[0] - p2[0]);
    }
}

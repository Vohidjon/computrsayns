package leetcode.medium;

import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 0) return 0;
        int[] DP = new int[triangle.size()];
        DP[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> row = triangle.get(i);
            int temp = DP[0];
            for (int j = 0; j < row.size(); j++) {
                int min;
                if (j == 0) {
                    min = row.get(j) + DP[j];
                } else if (j == row.size() - 1) {
                    min = row.get(j) + temp;
                } else {
                    min = row.get(j) + Math.min(DP[j], temp);
                }
                temp = DP[j];
                DP[j] = min;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < DP.length; i++) {
            if(min > DP[i]) min = DP[i];
        }
        return min;
    }
}

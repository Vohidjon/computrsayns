package leetcode.medium;

import java.util.*;

public class FindAndReplacePattern {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][][] DP = new int[piles.length][piles.length][2];
        for(int i = 0; i < n; i++) DP[i][i][1] = piles[i];
        for(int i = 1; i < n; i++) {
            int turn = (i + 1) % 2;
            int other = i % 2;
            for(int j = 0; j + i < n; j++) {
                if(DP[j][j + i - 1][turn] + piles[j + i] > DP[j + 1][j + i][turn] + piles[j]) {
                    DP[j][j + i][turn] = DP[j][j + i - 1][turn] + piles[j + i];
                    DP[j][j + i][other] = DP[j][j + i - 1][other];
                } else {
                    DP[j][j + i][turn] = DP[j + 1][j + i][turn] + piles[j];
                    DP[j][j + i][other] = DP[j + 1][j + i][other];
                }
            }
        }
        return DP[0][n - 1][0] > DP[0][n - 1][1];
    }

    public int singleNonDuplicate(int[] nums) {
        int i = 0;
        int j = nums.length;
        while(true) {
            int mid = i + (j - i) / 2 + 1;
            if((mid - 1 < 0 || nums[mid] != nums[mid - 1]) && (mid + 1 >= nums.length || nums[mid] != nums[mid + 1])) return nums[mid];

            if(nums[mid] == nums[mid + 1]) j = mid - 1;
            else i = mid + 1;
        }
    }
}

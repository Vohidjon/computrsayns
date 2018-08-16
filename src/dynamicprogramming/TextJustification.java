package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public String[] justify(String[] words, int width) {
        int[][] DP = new int[words.length][words.length];


        for (int i = 0; i < words.length; i++) {
            int length = 0;
            for (int j = i; j < words.length; j++) {
                if (length == 0) length += words[j].length();
                else length += words[j].length() + 1;

                if (length > width) DP[i][j] = -1;
                else DP[i][j] = (width - length) * (width - length);
            }
        }

        int[] costs = new int[words.length];
        int[] breaks = new int[words.length];
        for (int i = words.length - 1; i >= 0; i--) {
            if(DP[i][words.length - 1] != -1) {
                costs[i] = DP[i][words.length - 1];
                breaks[i] = words.length;
                continue;
            }
            int minCost = Integer.MAX_VALUE;
            int breakPoint = -1;
            for (int j = words.length - 1; j > i; j--) {
                if(DP[i][j - 1] != -1 && minCost > DP[i][j - 1] + costs[j]) {
                    minCost = DP[i][j - 1] + costs[j];
                    breakPoint = j;
                }
            }
            costs[i] = minCost;
            breaks[i] = breakPoint;
        }
        return reconstruct(breaks, words, 0).toArray(new String[0]);
    }

    private ArrayList<String> reconstruct(int[] breaks, String[] words, int i) {
        if(i == words.length) return new ArrayList<>();
        else {
            ArrayList list = reconstruct(breaks, words, breaks[i]);
            StringBuilder s = new StringBuilder();
            for (int j = i; j < breaks[i]; j++) {
                s.append(words[j]).append(" ");
            }
            list.add(s.toString());
            return list;
        }
    }
}

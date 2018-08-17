package dynamicprogramming;

import java.util.HashSet;

public class WordBreakProblem {

    public String breakWord(HashSet<String> dictionary, String sentence) {
        boolean[][] DP = new boolean[sentence.length()][sentence.length()];
        int[][] breakPoints = new int[sentence.length()][sentence.length()];
//        for (int i = 0; i < sentence.length(); i++) {
//            DP[i][i] = dictionary.contains(sentence.substring(i, i + 1));
//        }

        for (int len = 0; len < sentence.length(); len++) {
            for (int i = 0; i < sentence.length() - len; i++) {
                if (dictionary.contains(sentence.substring(i, i + len + 1))) {
                    DP[i][i + len] = true;
                    breakPoints[i][i + len] = i + len;
                    continue;
                }
                for (int j = 0; j < i + len; j++) {
                    if(DP[i][j] && DP[j + 1][i + len]) {
                        DP[i][i + len] = true;
                        breakPoints[i][i + len] = j;
                        break;
                    }
                }
            }
        }
        if(DP[0][sentence.length() - 1]) return reconstruct(breakPoints, sentence, 0, sentence.length() - 1);
        else return sentence;
    }

    private String reconstruct(int[][] breakPoints, String sentence, int i, int j) {
        if(breakPoints[i][j] == j) return sentence.substring(i, j + 1);
        else return reconstruct(breakPoints, sentence, i, breakPoints[i][j]) + " " + reconstruct(breakPoints, sentence, breakPoints[i][j] + 1, j);
    }
}

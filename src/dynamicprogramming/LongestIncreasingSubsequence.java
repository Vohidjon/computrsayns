package dynamicprogramming;

public class LongestIncreasingSubsequence {
    private static final int LENGTH = 0;
    private static final int PREDECESSOR = 1;

    public int lengthOf(String s) {
        if(s.isEmpty()) return 0;
        int[][] table = buildTable(s);
        return table[LENGTH][s.length()];
    }

    public String longestSubsequence(String s) {
        if(s.isEmpty()) return "";
        int[][] table = buildTable(s);
        return longestSubsequence(table, s, s.length());
    }

    private String longestSubsequence(int[][] table, String s, int i) {
        if(table[PREDECESSOR][i] == 0) {
            return "" + s.charAt(i - 1);
        } else {
            return longestSubsequence(table, s, table[PREDECESSOR][i]) + s.charAt(i - 1);
        }
    }

    private int[][] buildTable(String s) {
        int[] numbers = new int[s.length() + 1];
        int[] lengths = new int[s.length() + 1];
        int[] predecessors = new int[s.length() + 1];
        numbers[0] = -1;
        for (int i = 0; i < s.length(); i++) {
            numbers[i + 1] = Integer.parseInt(s.substring(i, i + 1));
        }
        lengths[0] = 0;
        predecessors[0] = -1;
        for (int i = 1; i <= s.length(); i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                if(numbers[j] < numbers[i] && lengths[max] < lengths[j]) {
                    max = j;
                }
            }

            lengths[i] = lengths[max] + 1;
            predecessors[i] = max;
        }
        return new int[][]{lengths, predecessors};
    }
}

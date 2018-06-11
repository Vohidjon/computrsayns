package leetcode.medium;

public class ZigZagConversion {
    public static String convert(String s, int numRows) {
        int pattern = numRows + ((numRows > 2) ? numRows - 2 : 0);
        StringBuffer output = new StringBuffer(s.length());
        for (int r = 1; r <= numRows; r++) {
            int i = 0;
            while (i < s.length() / pattern + 1) {
                int firstIndex = i * pattern + r;
                int secondIndex = firstIndex + (pattern - (2 * (r - 1)));
                if(firstIndex <= s.length()) output.append(s.charAt(firstIndex - 1));

                if(secondIndex <= s.length() && (r > 1 && r < numRows)) output.append(s.charAt(secondIndex - 1));
                i++;
            }
        }
        return output.toString();
    }
}

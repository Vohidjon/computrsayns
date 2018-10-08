package leetcode.medium;

public class MaximumSwap {
    public int maximumSwap(int num) {
        String s = String.valueOf(num);
        int i = 0;
        for (; i < s.length(); i++) {
            int iMax = i;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(iMax) <= s.charAt(j)) {
                    iMax = j;
                }
            }
            if (s.charAt(i) == s.charAt(iMax)) continue;

            char digitI = s.charAt(i);
            char digitIMax = s.charAt(iMax);
            char[] digits = s.toCharArray();
            digits[i] = digitIMax;
            digits[iMax] = digitI;
            return Integer.parseInt(new String(digits));
        }
        return num;
    }
}

package leetcode.medium;

public class ShiftingLetters {
    public static String shift(String S, int[] shifts) {
        int sum = 0;
        for (int i = shifts.length - 1; i >= 0; i--) {
            sum += shifts[i] % 26;
            shifts[i] = sum;
        }

        StringBuffer output = new StringBuffer();
        for (int i = 0; i < S.length(); i++) {
            output.append(shiftTimes(S.charAt(i), shifts[i]));
        }

        return output.toString();
    }

    public static char shiftTimes(char ch, int times) {
        int nthLetter = (ch - 96 + times) % 26;
        return (char) (96 + (nthLetter == 0 ? 26 : nthLetter));
    }
}

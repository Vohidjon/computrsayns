package leetcode.hard;

public class ScrambleString {
    public boolean isScramble(String original, String scramble) {
        int N = scramble.length();
        if (N == 1) return original.equals(scramble);
        if (N == 2)
            return original.equals(scramble) || (original.charAt(0) == scramble.charAt(1) && original.charAt(1) == scramble.charAt(0));
        boolean noScramble1 = isScramble(original.substring(0, N / 2), scramble.substring(0, N / 2));
        boolean noScramble2 = isScramble(original.substring(N / 2, N), scramble.substring(N / 2, N));
        boolean scramble1 = isScramble(original.substring(0, N / 2), scramble.substring(N / 2 + 1, N));
        boolean scramble2 = isScramble(original.substring(N / 2, N), scramble.substring(0, N / 2 + 1));
        return (noScramble1 && noScramble2) || (scramble1 && scramble2);
    }
}

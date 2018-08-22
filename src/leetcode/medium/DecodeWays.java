package leetcode.medium;

public class DecodeWays {
    public int numDecodings(String s) {
        int prePrev = 1;
        int prev = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= s.length(); i++) {
            int ways = 0;
            if(s.charAt(i - 1) != '0') {
                ways += prev;
            }
            if(s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) < '7')) {
                ways += prePrev;
            }
            int temp = prev;
            prev = ways;
            prePrev = temp;
        }
        return prev;
    }
}

package leetcode.easy;

public class PolindromeNumber {
    public static boolean isIt(int x) {
        if(x < 0 || x == 10) return false;
        int digits = (int) Math.ceil(Math.log10(x));
        int divider = (int) Math.pow(10, digits - 1);
        while (digits > 1) {
            int first = x / divider;
            int last = x % 10;
            x = (x % divider) / 10;
            if(first != last) return false;
            divider /= 100;
            digits -= 2;
        }
        return true;
    }
}

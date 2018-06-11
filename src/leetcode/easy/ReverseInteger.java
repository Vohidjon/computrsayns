package leetcode.easy;

public class ReverseInteger {
    public static int reverse(int x) {
        long reverseNum = 0;
        long num = x;
        boolean isPositive = x > 0;
        num = Math.abs(num);
        while (num != 0) {
            int lastDigit = (int)(num % 10);
            num /= 10;
            reverseNum = reverseNum * 10 + lastDigit;
        }
        if (isPositive && reverseNum > (long)Integer.MAX_VALUE) return 0;
        else if (reverseNum * -1 < (long)Integer.MIN_VALUE) return 0;

        return isPositive ? (int) reverseNum : -1 * (int) reverseNum;
    }
}

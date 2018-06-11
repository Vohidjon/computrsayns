package leetcode.medium;

public class StringToInteger {
    public static int myAtoi(String str) {
        boolean isPositive = true;
        boolean conversionStarted = false;
        char whiteSpace = ' ';
        char minus = '-';
        char plus = '+';
        long num = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(!conversionStarted && ch == whiteSpace) { // whitespace, continue we are okay
                continue;
            } else if(!conversionStarted && (ch == minus || ch == plus)) { // optional plus&minus sign, but only if it is the first char
                conversionStarted = true;
                isPositive = ch == plus;
            } else if(ch >= 48 && ch <= 57) {
                try {
                    num = Math.addExact(Math.multiplyExact(num, (long) 10), (long) (ch - 48));
                } catch (ArithmeticException e) {
                    if(isPositive) return Integer.MAX_VALUE;
                    else return Integer.MIN_VALUE;
                }
                conversionStarted = true;
            } else break;
        }

        if (!isPositive) num *= -1;
        if(num > (long)Integer.MAX_VALUE) return Integer.MAX_VALUE;
        else if(num < (long)Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return (int) num;
    }
}

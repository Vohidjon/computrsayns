package leetcode.medium;

public class DivideTwoIntegers {
    public static int divide(int dividend, int divisor) {
        if(divisor == 1) return dividend;
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if(dividend == Integer.MIN_VALUE && divisor == Integer.MIN_VALUE) return 1;
        if(divisor == Integer.MIN_VALUE) return 0;

        boolean negative = false;
        if ((dividend & (1 << 31)) == (1 << 31)) { // Check for signed bit
            negative = !negative;
            dividend = ~dividend + 1;  // Negation
        }
        if ((divisor & (1 << 31)) == (1 << 31)) {
            negative = !negative;
            divisor = ~divisor + 1;  // Negation
        }

        int quotient = 0;
        long r;
        for (int i = 30; i >= 0; i--) {
            r = (divisor << i); // Left shift divisor until it's smaller than dividend
            if (r < Integer.MAX_VALUE && r >= 0) { // Avoid cases where comparison between long and int doesn't make sense
                if (r <= dividend) {
                    quotient |= (1 << i);
                    dividend = dividend - (int) r;
                }
            }
        }
        if (negative) {
            quotient = ~quotient + 1;
        }
        return quotient;

//        if(divisor == 1) return dividend;
//        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
//        if(dividend == Integer.MIN_VALUE && divisor == Integer.MIN_VALUE) return 1;
//        if(divisor == Integer.MIN_VALUE) return 0;
//        int result = 0;
//        if(dividend < 0 && divisor < 0) { // both negative
//            while (dividend <= divisor) {
//                dividend -= divisor;
//                result++;
//            }
//        } else if(dividend < 0) { // only dividend negative
//            if(dividend == Integer.MIN_VALUE) {
//                dividend += divisor;
//                result = 1;
//            }
//            while (-dividend >= divisor) {
//                dividend += divisor;
//                result++;
//            }
//            return -result;
//        } else if(divisor < 0) { // only divisor negative
//            while (dividend >= -divisor) {
//                dividend += divisor;
//                result++;
//            }
//            return -result;
//        } else { // both positive
//            while (dividend >= divisor) {
//                dividend -= divisor;
//                result++;
//            }
//        }
//
//        return result;
    }
}

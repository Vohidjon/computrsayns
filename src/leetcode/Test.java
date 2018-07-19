package leetcode;


import leetcode.hard.LongestValidParentheses;

public class Test {
    public static void main(String[] args) {
//        System.out.println(DivideTwoIntegers.divide(Integer.MIN_VALUE, -1));
//        System.out.println(DivideTwoIntegers.divide(Integer.MIN_VALUE, Integer.MIN_VALUE));
//        System.out.println(DivideTwoIntegers.divide(526, Integer.MIN_VALUE));
//        System.out.println(DivideTwoIntegers.divide(9, 2));
//        System.out.println(DivideTwoIntegers.divide(-9, -2));
//        System.out.println(DivideTwoIntegers.divide(-9, 2));
//        System.out.println(DivideTwoIntegers.divide(9, -2));
//        long time = System.nanoTime();
//        System.out.println(DivideTwoIntegers.divide(Integer.MAX_VALUE, 2));
//        System.out.println(System.nanoTime() - time);
        assert LongestValidParentheses.longestValidParentheses("(()(((()") == 2;
        assert LongestValidParentheses.longestValidParentheses("()(()") == 2;
        assert LongestValidParentheses.longestValidParentheses("(()") == 2;
        assert LongestValidParentheses.longestValidParentheses(")()())") == 4;
        assert LongestValidParentheses.longestValidParentheses("(()())())(((())))()()()(())(") == 18;
    }
}

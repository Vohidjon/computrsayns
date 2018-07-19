package leetcode.hard;

import java.util.Stack;

public class LongestValidParentheses {
    // > <<><><<>>><> > <><> ><<<<< <> <<<<<<<>>>>>>>>
    public static int longestValidParentheses(String s) {
        int longest = 0;
        boolean[] bubblePops = new boolean[s.length()];
        boolean somePop = true;
        while (somePop) {
            for (int i = 0; i < s.length(); i++) {

            }
        }
        return longest;
    }

    private static boolean isMatch(char ch1, char ch2) {
        return (ch1 == '(' && ch2 == ')');
    }
//    public static int longestValidParentheses(String s) {
//        int longest = 0,
//                opening = 0,
//                closing = 0,
//                plus = 0;
//        for (int i = 0; i < s.length(); i++) {
//            char ch = s.charAt(i);
//            if (ch == '(') { // open
//                opening++;
//            } else {
//                closing++;
//            }
//
//            if (opening < closing) { // end of valid paren
//                if (opening + plus > longest) longest = opening + plus;
//                opening = 0;
//                closing = 0;
//                plus = 0;
//            } else if (opening == closing) { // valid paren
//                plus += opening;
//                opening = 0;
//                closing = 0;
//            }
//        }
//        if(plus > longest) longest = plus;
//        if (closing > longest) longest = closing;
//        return longest * 2;
//    }
}

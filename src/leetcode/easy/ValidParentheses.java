package leetcode.easy;

import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (stack.isEmpty() || !isMatch(stack.peek(), ch)) stack.push(ch);
            else stack.pop();
        }
        return stack.isEmpty();
    }

    private static boolean isMatch(char ch1, char ch2) {
        return (ch1 == '(' && ch2 == ')') ||
                (ch1 == '{' && ch2 == '}') ||
                (ch1 == '[' && ch2 == ']');
    }
}

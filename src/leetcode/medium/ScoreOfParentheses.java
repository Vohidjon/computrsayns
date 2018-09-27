package leetcode.medium;

import java.util.Stack;

public class ScoreOfParentheses {
    public int scoreOfParentheses(String S) {
        Stack stack = new Stack<>();
        stack.push(0);
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else { // closing
                if(stack.peek() instanceof Character) {
                    stack.pop(); // remove (
                    if(stack.peek() instanceof Integer) { // update score
                        int lastScore = (int) stack.pop();
                        stack.push(lastScore + 1);
                    } else { // just add score
                        stack.push(1);
                    }
                } else {
                    int lastScore = (int) stack.pop();
                    stack.pop(); // remove (
                    lastScore *= 2;
                    if(stack.peek() instanceof Integer) { // update score
                        stack.push((int) stack.pop() + lastScore);
                    } else { // just add score
                        stack.push(lastScore);
                    }
                }
            }
        }
        return (int) stack.pop();
    }
    public int scoreOfParenthesesBetterVersion(String S) {
        Stack<Integer> depth = new Stack<>();
        depth.push(0);

        for (char c : S.toCharArray()) {
            if (c == '(') {
                depth.push(0);
            } else {
                int current = depth.pop();
                int prev = depth.pop();
                depth.push(prev + Math.max(2 * current, 1));
            }
        }
        return depth.pop();
    }
}

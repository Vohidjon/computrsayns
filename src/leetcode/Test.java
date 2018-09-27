package leetcode;


import leetcode.medium.ScoreOfParentheses;

public class Test {
    public static void main(String[] args) {
        System.out.println(new ScoreOfParentheses().scoreOfParentheses("()"));
        System.out.println(new ScoreOfParentheses().scoreOfParentheses("(())"));
        System.out.println(new ScoreOfParentheses().scoreOfParentheses("()()"));
        System.out.println(new ScoreOfParentheses().scoreOfParentheses("(()(()))"));
        System.out.println(new ScoreOfParentheses().scoreOfParentheses(""));
        System.out.println(new ScoreOfParentheses().scoreOfParentheses("(()()(()))(()())"));
    }
}

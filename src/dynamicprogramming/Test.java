package dynamicprogramming;


public class Test {
    public static void main(String[] args) {
        System.out.println(new RegularExpressionMatching().isMatch("a.cd*", "abcddd"));
        System.out.println("--TRUE");
        System.out.println(new RegularExpressionMatching().isMatch("a.b", "acb"));
        System.out.println(new RegularExpressionMatching().isMatch("a.b", "aab"));
        System.out.println(new RegularExpressionMatching().isMatch("a.b", "axb"));
        System.out.println("--FALSE");
        System.out.println(new RegularExpressionMatching().isMatch("a.b", "ab"));
        System.out.println(new RegularExpressionMatching().isMatch("a.b", "acby"));
        System.out.println(new RegularExpressionMatching().isMatch("a.b", "cb"));
        System.out.println("--TRUE");
        System.out.println(new RegularExpressionMatching().isMatch("a*b", "b"));
        System.out.println(new RegularExpressionMatching().isMatch("a*b", "ab"));
        System.out.println(new RegularExpressionMatching().isMatch("a*b", "aab"));
        System.out.println(new RegularExpressionMatching().isMatch("a*b", "aaab"));
        System.out.println("--FALSE");
        System.out.println(new RegularExpressionMatching().isMatch("a*b", "a"));
        System.out.println(new RegularExpressionMatching().isMatch("a*b", "acb"));
        System.out.println("--TRUE");
        System.out.println(new RegularExpressionMatching().isMatch("a*b.*y", "by"));
        System.out.println(new RegularExpressionMatching().isMatch("a*b.*y", "bly"));
        System.out.println(new RegularExpressionMatching().isMatch("a*b.*y", "ably"));
        System.out.println(new RegularExpressionMatching().isMatch("a*b.*y", "ablmy"));
        System.out.println("--FALSE");
        System.out.println(new RegularExpressionMatching().isMatch("a*b.*y", "ay"));
        System.out.println(new RegularExpressionMatching().isMatch("a*b.*y", "ab"));
    }
}

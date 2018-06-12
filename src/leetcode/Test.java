package leetcode;


import leetcode.hard.RegularExpressionMatching;

public class Test {
    public static void main(String[] args) {
        assert RegularExpressionMatching.isMatch("a", "ab*") == true;
        assert RegularExpressionMatching.isMatch("mm", "a*") == false;
        assert RegularExpressionMatching.isMatch("mississippi", "mis*is*ip*.") == true;
        assert RegularExpressionMatching.isMatch("", "") == true;
        assert RegularExpressionMatching.isMatch("aa", "a") == false;
        assert RegularExpressionMatching.isMatch("aa", "a*") == true;
        assert RegularExpressionMatching.isMatch("ab", ".*") == true;
        assert RegularExpressionMatching.isMatch("aab", "c*a*b") == true;
        assert RegularExpressionMatching.isMatch("mississippi", "mis*is*p.") == false;
    }
}

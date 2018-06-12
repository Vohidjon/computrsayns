package leetcode.hard;

public class RegularExpressionMatching {
    public static boolean isMatch(String s, String p) {
        if (s.isEmpty() && p.isEmpty()) return true;
        else if (p.isEmpty()) return false;
        int pi = 0;
        int si = 0;
        char pElement = p.charAt(pi);

        boolean isNextAsterisk = 1 < p.length() && p.charAt(1) == '*';
        if (pElement == '.' && isNextAsterisk) { // zero or more (*) of any character (.)
            if (isMatch(s, p.substring(2))) return true; // zero
            while (si < s.length()) { // or more
                if (isMatch(s.substring(++si), p.substring(2))) return true;
            }
            return false;
        } else if (isNextAsterisk) { // zero or more (*) of pElement character (.)
            // check all possible ways
            if (isMatch(s, p.substring(2))) return true; // zero
            while (si < s.length() && pElement == s.charAt(si)) { // or more
                if (isMatch(s.substring(++si), p.substring(2))) return true;
            }
            return false;
        } else if (si < s.length() && (pElement == s.charAt(si) || pElement == '.')) { // we are cool
            return isMatch(s.substring(si + 1), p.substring(pi + 1));
        } else return false;
    }
}

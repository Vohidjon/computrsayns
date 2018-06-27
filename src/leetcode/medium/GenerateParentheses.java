package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> paren = new ArrayList<>();
        generateRec("", n, n, paren);
        return paren;
    }

    public static void generateRec(String s, int open, int closed, List<String> list) {
        if (open == 0 && closed == 0) { // end case for recursion
            list.add(s);
        } else if (open == 0) {
            generateRec(s + ')', open, closed - 1, list);
        } else if (open == closed) { // have to start with opening paren
            generateRec(s + '(', open - 1, closed, list);
        } else {
            generateRec(s + '(', open - 1, closed, list);
            generateRec(s + ')', open, closed - 1, list);
        }
    }
}

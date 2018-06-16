package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
    private static char[][] numPad = new char[][]{
            new char[]{'a', 'b', 'c'},
            new char[]{'d', 'e', 'f'},
            new char[]{'g', 'h', 'i'},
            new char[]{'j', 'k', 'l'},
            new char[]{'m', 'n', 'o'},
            new char[]{'p', 'q', 'r', 's'},
            new char[]{'t', 'u', 'v'},
            new char[]{'w', 'x', 'y', 'z'},
    };

    public static List<String> letterCombinations(String digits) {
        List<String> output = new ArrayList<>();
        List<String> temp = new ArrayList<>();

        for (int i = digits.length() - 1; i >= 0; i--) {
            int number = Integer.parseInt(String.valueOf(digits.charAt(i)));
            output = new ArrayList<>();
            if (temp.isEmpty()) {
                for (char ch : numPad[number - 2]) {
                    output.add(String.valueOf(ch));
                }
            } else {
                for (int l = 0; l < numPad[number - 2].length; ++l) {
                    for (String s : temp) {
                        output.add(numPad[number - 2][l] + s);
                    }
                }
            }
            temp = output;
        }

        return output;
    }

    private static List<String> letterRecursive(String digits) {
        List<String> output = new ArrayList<>();
        if (digits.length() == 0) return new ArrayList<>();
        int number = Integer.parseInt(String.valueOf(digits.charAt(0)));
        List<String> innerOutput = letterRecursive(digits.substring(1));
        if (innerOutput.isEmpty()) {
            for (char ch : numPad[number - 2]) {
                output.add(String.valueOf(ch));
            }
            return output;
        }
        for (int l = 0; l < numPad[number - 2].length; ++l) {

            for (String s : innerOutput) {
                output.add(numPad[number - 2][l] + s);
            }
        }
        return output;
    }
}

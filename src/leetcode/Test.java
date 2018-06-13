package leetcode;


import leetcode.easy.RomanToInteger;
import leetcode.medium.IntegerToRoman;

public class Test {
    public static void main(String[] args) {
        for (int i = 1; i <= 3999; i++) {
            assert i == RomanToInteger.romanToInt(IntegerToRoman.intToRoman(i));
        }
    }
}

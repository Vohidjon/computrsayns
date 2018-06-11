package leetcode;


import leetcode.easy.PolindromeNumber;

public class Test {
    public static void main(String[] args) {
        assert PolindromeNumber.isIt(10) == false;
        assert PolindromeNumber.isIt(-121) == false;
        assert PolindromeNumber.isIt(121) == true;
        assert PolindromeNumber.isIt(1231) == false;
        assert PolindromeNumber.isIt(1256521) == true;
        assert PolindromeNumber.isIt(1000021) == false;
    }
}

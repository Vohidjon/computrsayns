package leetcode;


import leetcode.hard.InterleavingString;

public class Test {
    public static void main(String[] args) {
        System.out.println(new InterleavingString().isInterleave("ccab", "ccbdz", "ccbcdcabz"));
        System.out.println(new InterleavingString().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(new InterleavingString().isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        System.out.println(new InterleavingString().isInterleave("a", "b", "a"));
    }
}

package leetcode;


import leetcode.medium.NumberOfIslands;

public class Test {
    public static void main(String[] args) {
        System.out.println(new NumberOfIslands().numIslands(new char[][]{
                new char[]{'1', '0', '0', '1', '0', '1', '1'},
                new char[]{'1', '1', '0', '1', '0', '1', '1'},
                new char[]{'0', '1', '0', '1', '1', '0', '1'},
                new char[]{'0', '0', '1', '0', '0', '0', '0'},
                new char[]{'1', '1', '0', '0', '0', '1', '0'},
                new char[]{'1', '1', '1', '0', '1', '1', '0'},
        }));
        System.out.println(new NumberOfIslands().numIslands(new char[][]{
                new char[] {'1', '1', '1'},
                new char[] {'1', '0', '1'},
                new char[] {'1', '1', '1'},
        }));
    }
}

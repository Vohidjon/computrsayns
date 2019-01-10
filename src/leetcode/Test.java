package leetcode;


import leetcode.easy.RecentCounter;

public class Test {
    public static void main(String[] args) {
        RecentCounter rc = new RecentCounter();
        for (int i: new int[] {1, 100, 3001, 3002}) {
            System.out.println(rc.ping(i));
        }
    }
}

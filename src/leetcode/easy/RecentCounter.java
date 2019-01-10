package leetcode.easy;

import java.util.LinkedList;

public class RecentCounter {
    private LinkedList<Integer> pings;
    public RecentCounter() {
        pings = new LinkedList<>();
    }

    public int ping(int t) {
        pings.addLast(t);
        int first = pings.getFirst();
        while (t - 3000 > first) {
            pings.removeFirst();
            first = pings.getFirst();
        }
        return pings.size();
    }
}

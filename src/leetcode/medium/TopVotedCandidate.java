package leetcode.medium;

public class TopVotedCandidate {
    private int[] times;
    private int[] tops;
    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        this.tops = new int[times.length];
        int[] DP = new int[persons.length];
        DP[persons[0]] = 1;
        tops[0] = persons[0];
        for (int i = 1; i < times.length; i++) {
            DP[persons[i]]++;
            tops[i] = tops[i - 1];
            if(DP[tops[i]] <= DP[persons[i]]) tops[i] = persons[i];
        }
    }

    public int q(int t) {
        return tops[findTime(t)];
    }

    private int findTime(int time) {
        if(time >= times[times.length - 1]) return times.length - 1;
        int min = 0;
        int max = times.length - 1;
        while (min <= max) {
            int mid = min + (max - min) / 2 + (max - min) % 2;
            if (times[mid] < time) {
                min = mid + 1;
            } else if(times[mid] > time) {
                max = mid - 1;
            } else {
                return mid;
            }
        }
        return max;
    }
}

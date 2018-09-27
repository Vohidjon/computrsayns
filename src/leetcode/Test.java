package leetcode;


import leetcode.medium.FindFirstAndLastPositionOfElementInSortedArray;
import leetcode.medium.SearchInRotatedSortedArray;
import leetcode.medium.TopVotedCandidate;

public class Test {
    public static void main(String[] args) {
        int[] persons = new int[]{0, 1, 0, 1, 1};
        int[] times = new int[]{24, 29, 31, 76, 81};
        TopVotedCandidate candidate = new TopVotedCandidate(persons, times);
        System.out.println(candidate.q(28));
        System.out.println(candidate.q(24));
        System.out.println(candidate.q(29));
        System.out.println(candidate.q(77));
        System.out.println(candidate.q(30));
        System.out.println(candidate.q(25));
        System.out.println(candidate.q(76));
        System.out.println(candidate.q(75));
        System.out.println(candidate.q(81));
        System.out.println(candidate.q(80));

    }
}

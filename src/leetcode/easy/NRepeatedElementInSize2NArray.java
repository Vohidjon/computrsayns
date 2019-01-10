package leetcode.easy;

public class NRepeatedElementInSize2NArray {
    public int repeatedNTimes(int[] A) {
        int[] count = new int[10000];
        for (int i = 0; i < A.length; i++) {
            if(++count[A[i]] > 1) return A[i];
        }
        return -1;
    }
}

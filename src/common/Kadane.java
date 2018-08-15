package common;

public class Kadane {
    public static final int START = 0;
    public static final int END = 1;
    public static final int SUM = 2;
    public int maxSumContiguous(int[] arr) {
        int size = arr.length;
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;

        for (int i = 0; i < size; i++) {
            maxEndingHere = maxEndingHere + arr[i];
            if (maxSoFar < maxEndingHere)
                maxSoFar = maxEndingHere;
            if (maxEndingHere < 0)
                maxEndingHere = 0;
        }
        return maxSoFar;
    }

    public int[] maxSumContiguousSubArray(int[] arr) {
        int size = arr.length;
        int maxSoFarStart = 0;
        int maxSoFarEnd = -1;
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;
        int maxEndingHereStart = 0;

        for (int i = 0; i < size; i++) {
            maxEndingHere = maxEndingHere + arr[i];
            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
                maxSoFarStart = maxEndingHereStart;
                maxSoFarEnd = i;
            }
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
                maxEndingHereStart = i + 1 ;
            }
        }

        return new int[]{maxSoFarStart, maxSoFarEnd, maxSoFar};
    }
}

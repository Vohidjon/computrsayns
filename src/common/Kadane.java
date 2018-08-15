package common;

public class Kadane {
    public int maxSumContigiousSubArray(int[] arr) {
        int size = arr.length;
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;

        for (int i = 0; i < size; i++)
        {
            maxEndingHere = maxEndingHere + arr[i];
            if (maxSoFar < maxEndingHere)
                maxSoFar = maxEndingHere;
            if (maxEndingHere < 0)
                maxEndingHere = 0;
        }
        return maxEndingHere;
    }
}

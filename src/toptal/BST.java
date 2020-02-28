package toptal;


import java.util.Arrays;
import java.util.Comparator;

public class BST {
    public static void main(String[] args) {
        int a = 1^1^1^2;
        assert bSearch(new int[]{1, 2, 3, 4, 5}, 3) == 2;
        assert bSearch(new int[]{1, 2, 3, 4, 5}, 9) == -6;
        assert bSearch(new int[]{1, 2, 3, 4, 5}, -9) == -1;
        assert bSearch(new int[]{1, 3, 4, 5}, 2) == -2;
        assert bSearchRecur(new int[]{1, 2, 3, 4, 5}, 3) == 2;
        assert bSearchRecur(new int[]{1, 2, 3, 4, 5}, 9) == -6;
        assert bSearchRecur(new int[]{1, 2, 3, 4, 5}, -9) == -1;
        assert bSearchRecur(new int[]{1, 3, 4, 5}, 2) == -2;
    }
    public static int bSearch(int[] arr, int val) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if(arr[mid] < val) {
                lo = mid + 1;
            } else if(arr[mid] > val) {
                hi = mid - 1;
            } else return mid;
        }
        return -(lo + 1);
    }
    public static int bSearchRecur(int[] arr, int val) {
        return bSearchRecur0(arr, val, 0, arr.length - 1);
    }

    private static int bSearchRecur0(int[] arr, int val, int lo, int hi) {
        if(lo > hi) return -(lo + 1);

        int mid = (lo + hi) / 2;
        if(arr[mid] < val) {
            return bSearchRecur0(arr, val, mid + 1, hi);
        } else if(arr[mid] > val) {
            return bSearchRecur0(arr, val, lo, mid - 1);
        } else return mid;
    }
}

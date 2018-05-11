package seaching;

public class BinarySearch { // 10 11 13 14 52 70 88
    // 0  1  2  3  4  5  6
    public static int search(int value, int[] arr) {
        int min = 0;
        int max = arr.length - 1;
        while (min <= max) {
            int mid = min + (max - min) / 2 + (max - min) % 2;
            if (arr[mid] > value) {
                max = mid - 1;
            } else if (arr[mid] < value) {
                min = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int searchRecursive(int value, int[] arr) {
        return searchRecursive(value, arr, 0, arr.length - 1);
    }

    private static int searchRecursive(int value, int[] arr, int min, int max) {
        if (min > max) return -1;
        int mid = min + (max - min) / 2 + (max - min) % 2;
        if (arr[mid] > value) {
            return searchRecursive(value, arr, min, mid - 1);
        } else if (arr[mid] < value) {
            return searchRecursive(value, arr, min + 1, max);
        } else {
            return mid;
        }
    }
}

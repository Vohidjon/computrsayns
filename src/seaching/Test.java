package seaching;

public class Test {
    public static void main(String[] args) {
        int[] arr = new int[] {13, 24, 34, 40, 50, 61, 63, 70, 72, 80, 81, 85};
        System.out.println("13 is at " + BinarySearch.search(13, arr));
        System.out.println("85 is at " + BinarySearch.search(85, arr));
        System.out.println("61 is at " + BinarySearch.search(61, arr));
        System.out.println("63 is at " + BinarySearch.search(63, arr));
        System.out.println("65 is at " + BinarySearch.search(65, arr));
        System.out.println("84 is at " + BinarySearch.search(84, arr));


        System.out.println("13 is at " + BinarySearch.searchRecursive(13, arr));
        System.out.println("85 is at " + BinarySearch.searchRecursive(85, arr));
        System.out.println("61 is at " + BinarySearch.searchRecursive(61, arr));
        System.out.println("63 is at " + BinarySearch.searchRecursive(63, arr));
        System.out.println("65 is at " + BinarySearch.searchRecursive(65, arr));
        System.out.println("84 is at " + BinarySearch.searchRecursive(84, arr));


    }
}

package dynamicprogramming;

public class MinJumpToReachEnd {
    private static final int NUMBER_OF_JUMPS = 0;
    private static final int JUMPS = 1;
    public int min(int[] arr) {
        int[] table = buildTable(arr)[NUMBER_OF_JUMPS];
        return table[arr.length - 1];
    }

    public String jumps(int[] arr) {
        int[][] table = buildTable(arr);
        return reconstruct(table[JUMPS], arr.length - 1);
    }

    private String reconstruct(int[] jumps, int i) {
        if(i == 0) return "0";
        else return reconstruct(jumps, jumps[i]) + "," + i;
    }

    private int[][] buildTable(int[] arr) {
        int[] numOfJumps = new int[arr.length];
        int[] jumps = new int[arr.length];

        for (int i = 0; i < jumps.length; i++) jumps[i] = -1;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if(j + arr[j] >= i) {
                    if(numOfJumps[i] == 0 || numOfJumps[j] + 1 < numOfJumps[i]){
                        numOfJumps[i] = numOfJumps[j] + 1;
                        jumps[i] = j;
                    }
                }
            }
        }
        return new int[][]{numOfJumps, jumps};
    }
}

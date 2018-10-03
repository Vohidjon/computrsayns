package leetcode.medium;

public class FruitIntoBaskets {
    public int totalFruit(int[] tree) {
        if(tree.length == 1) return 1;
        int i = 0;
        int j = 2;
        int aLatest = 0;
        int bLatest = 1;
        int max = 0;
        for (; j < tree.length; j++) {
            if(tree[j] == tree[aLatest]) {
                if(tree[j] != tree[j - 1]) {
                    aLatest = j;
                }
            } else if(tree[j] == tree[bLatest]) {
                if(tree[j] != tree[j - 1]) {
                    bLatest = j;
                }
            } else { // time to shift start
                max = Math.max(max, j - i);
                if(tree[j - 1] == tree[aLatest]) {
                    i = aLatest;
                    bLatest = j;
                } else {
                    i = bLatest;
                    aLatest = j;
                }
            }
        }
        max = Math.max(max, j - i);
        return max;
    }
}

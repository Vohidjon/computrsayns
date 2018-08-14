package dynamicprogramming;

import java.util.Arrays;

public class BoxStackingProblem {
    private static final int HEIGHTS = 0;
    private static final int ON_TOP_OFS = 1;

    private static final int BOX_LENGTH = 0;
    private static final int BOX_WIDTH = 1;
    private static final int BOX_HEIGHT = 2;

    public int maxHeight(int[][] boxes) {
        int[][] permutations = permute(boxes);
        int[] heights = buildTable(permutations)[HEIGHTS];
        int max = heights[0];
        for (int i = 1; i < heights.length; i++) {
            if(max < heights[i]) max = heights[i];
        }
        return max;
    }
    public String stack(int[][] boxes) {
        int[][] permutations = permute(boxes);
        int[][] results = buildTable(permutations);
        int[] heights = results[HEIGHTS];
        int[] onTopOfs = results[ON_TOP_OFS];
        int max = 0;
        for (int i = 1; i < heights.length; i++) {
            if(heights[max] < heights[i]) max = i;
        }
        return reconstruct(permutations, onTopOfs, max);
    }

    private String reconstruct(int[][] boxes, int[] onTopOfs, int i) {
        if(onTopOfs[i] == i) return "{" + boxes[i][BOX_LENGTH] + "," + boxes[i][BOX_WIDTH] + "," + boxes[i][BOX_HEIGHT] + "}";
        else return reconstruct(boxes, onTopOfs, onTopOfs[i]) + ",{" + boxes[i][BOX_LENGTH] + "," + boxes[i][BOX_WIDTH] + "," + boxes[i][BOX_HEIGHT] + "}";
    }

    private int[][] permute(int[][] boxes) {
        // permute all box sides
        int[][] allBoxes = new int[boxes.length * 3][];
        for (int i = 0; i < boxes.length; i++) {
            int[] box = Arrays.copyOf(boxes[i], 3);
            Arrays.sort(box);
            allBoxes[i * 3] = new int[]{box[BOX_HEIGHT], box[BOX_WIDTH], box[BOX_LENGTH]};
            allBoxes[i * 3 + 1] = new int[]{box[BOX_HEIGHT], box[BOX_LENGTH], box[BOX_WIDTH]};
            allBoxes[i * 3 + 2] = new int[]{box[BOX_WIDTH], box[BOX_LENGTH], box[BOX_HEIGHT]};
        }

        Arrays.sort(allBoxes, (a, b) -> b[BOX_LENGTH] * b[BOX_WIDTH] - a[BOX_LENGTH] * a[BOX_WIDTH]);
        return allBoxes;
    }

    private int[][] buildTable(int[][] boxes) {
        int[] heights = new int[boxes.length];
        int[] onTopOfs = new int[boxes.length];
        for (int i = 0; i < boxes.length; i++) {
            heights[i] = boxes[i][BOX_HEIGHT];
            onTopOfs[i] = i;
        }
        for (int i = 1; i < boxes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (boxes[i][BOX_LENGTH] < boxes[j][BOX_LENGTH] && boxes[i][BOX_WIDTH] < boxes[j][BOX_WIDTH]) {
                    heights[i] = heights[j] + boxes[i][BOX_HEIGHT];
                    onTopOfs[i] = j;
                }
            }
        }
        return new int[][] {heights, onTopOfs};
    }
}

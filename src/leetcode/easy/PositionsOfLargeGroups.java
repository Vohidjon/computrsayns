package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class PositionsOfLargeGroups {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> result = new ArrayList<>();
        int start = 0;
        for (int i = 1; i < S.length(); i++) {
            if(S.charAt(i) != S.charAt(i - 1)) {
                if(i - start >= 3) {
                    List<Integer> group = new ArrayList<>();
                    group.add(start);
                    group.add(i - 1);
                    result.add(group);
                }
                start = i;
            }
        }
        if(S.length() - start >= 3) {
            List<Integer> group = new ArrayList<>();
            group.add(start);
            group.add(S.length() - 1);
            result.add(group);
        }
        return result;
    }
}

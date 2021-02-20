package leetcode.medium;

import java.util.*;

public class DecodeXoredPermutation {
    public int[] decode(int[] encoded) {
        int len = encoded.length + 1;
        Map<Integer, List<int[]>> xored = new HashMap<>();

        for (int i = 1; i <= len; i++) {
            for (int j = i + 1; j <= len; j++) {
                List<int[]> bucket = xored.getOrDefault(i ^ j, new LinkedList<>());
                bucket.add(new int[] {i, j});
                xored.put(i ^ j, bucket);
            }
        }

        int[] decoded = new int[len];
        Set<Integer> used = new HashSet<>();

        List<int[]> startBucket = xored.get(encoded[0]);
        for (int[] pair : startBucket) {
            // either pair[0] or pair[1] comes first
            // break as soon as there is a valid answer
            used.add(pair[0]);
            used.add(pair[1]);
            decoded[0] = pair[0];
            decoded[1] = pair[1];
            if (backtrack(1, len, encoded, decoded, xored, used)) break;

            decoded[0] = pair[1];
            decoded[1] = pair[0];
            if (backtrack(1, len, encoded, decoded, xored, used)) break;

            used.remove(pair[0]);
            used.remove(pair[1]);
        }
        Integer[] a = new HashMap<Integer,Integer>().keySet().stream().sorted().toArray(Integer[]::new);
        Arrays.sort(a);
        return decoded;
    }

    private boolean backtrack(int k,
                              int len,
                              int[] encoded,
                              int[] decoded,
                              Map<Integer, List<int[]>> xored,
                              Set<Integer> used) {
        if (k + 1 >= len) return true;

        int op1 = decoded[k];
        List<int[]> bucket = xored.get(encoded[k]);

        for (int[] pair : bucket) {
            if (pair[0] != op1 && pair[1] != op1) continue;
            int op2 = op1 ^ pair[0] ^ pair[1];
            if (used.contains(op2)) continue;

            decoded[k + 1] = op2;
            used.add(op2);

            if (backtrack(k + 1, len, encoded, decoded, xored, used)) {
                return true;
            }

            used.remove(op2);
        }

        return false;
    }
}

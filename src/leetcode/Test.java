package leetcode;


import leetcode.medium.DecodeXoredPermutation;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        t.insert("apple");
        System.out.println(t.search("apple"));
    }

    private TrieNode root;
    private static class TrieNode {
        char value;
        TrieNode[] children;
        TrieNode (char value) {
            this.value = value;
            children = new TrieNode[26];
        }
    }
    /** Initialize your data structure here. */
    public Test() {
        this.root = new TrieNode(' ');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.children[ch - 'a'] == null) node.children[ch - 'a'] = new TrieNode(ch);
            node = node.children[ch - 'a'];
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.children[ch - 'a'] == null) return false;
            node = node.children[ch - 'a'];
        }
        return node == null;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            if (node.children[ch - 'a'] == null) return false;
            node = node.children[ch - 'a'];
        }
        return true;
    }

    public int maxPoints(int[][] points) {
        int res = 0;
        for(int[] p1 : points) {
            Map<Float, Integer> m = new HashMap<>();
            int max = 0;
            for(int[] p2 : points) {
                if(p1 == p2) continue;
                float slope = this.calcSlope(p1, p2);
                int c = m.getOrDefault(slope, 0) + 1;
                max = Math.max(max, c);
                m.put(slope, c);
            }
            res = Math.max(res, max);
        }
        return res + 1;
    }

    private float calcSlope(int[] p1, int[] p2) {
        return ((float)(p1[1] - p2[1])) / (p1[0] - p2[0]);
    }

    private final int BLOCK = -1;
    public int shortestPathBinaryMatrix(int[][] grid) {
        int len = grid.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++){
                if (grid[i][j] == 0) grid[i][j] = count++;
                else grid[i][j] = BLOCK;
            }
        }
        List<Integer>[] graph = new List[count];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (grid[i][j] == BLOCK) continue;
                List<Integer> adj = new ArrayList(8);
                // 8 ways clockwise
                // top
                if (i - 1 >= 0 && grid[i - 1][j] != BLOCK)
                    adj.add(grid[i - 1][j]);

                // top-right
                if (i - 1 >= 0 && j + 1 < len && grid[i - 1][j + 1] != BLOCK)
                    adj.add(grid[i - 1][i + 1]);

                // right
                if (j + 1 < len && grid[i][j + 1] != BLOCK)
                    adj.add(grid[i][j + 1]);

                // right-bottom
                if (i + 1 < len && j + 1 < len && grid[i + 1][j + 1] != BLOCK)
                    adj.add(grid[i + 1][j + 1]);

                // bottom
                if (i + 1 < len && grid[i + 1][j] != BLOCK)
                    adj.add(grid[i + 1][j]);

                // bottom-left
                if (i + 1 < len && j - 1 >= 0 && grid[i + 1][j - 1] != BLOCK)
                    adj.add(grid[i + 1][j - 1]);

                // left
                if (j - 1 >= 0 && grid[i][j - 1] != BLOCK)
                    adj.add(grid[i][j - 1]);

                // left-top
                if (i - 1 >= 0 && j - 1 >= 0 && grid[i - 1][j - 1] != BLOCK)
                    adj.add(grid[i - 1][j - 1]);

                graph[grid[i][j]] = adj;
            }
        }

        Integer[] distances = shortestPath(graph);

        return distances[count - 1] == Integer.MAX_VALUE ? - 1 : distances[count - 1];
    }

    private Integer[] shortestPath(List<Integer>[] graph) {
        int len = graph.length;

        boolean[] processed = new boolean[len];
        Integer[] distances = new Integer[len];

        for (int i = 0; i < len; i++) {
            distances[i] = i == 0 ? 0 : Integer.MAX_VALUE;
        }

        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(0);

        while (!queue.isEmpty()) {
            Integer v = queue.poll();
            processed[v] = true;

            for (Integer u : graph[v]) {
                if (!processed[u] && distances[u] == Integer.MAX_VALUE) {
                    distances[u] = distances[v] + 1;
                    queue.add(u);
                }
            }
        }

        return distances;
    }
}

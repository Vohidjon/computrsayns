package leetcode.medium;

import java.util.*;

public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] A) {
        int n = A.length;
        LinkedList<Vertex>[] graph = new LinkedList[n * n + 2];
        LinkedList<Vertex> start = new LinkedList<Vertex>();
        for(int i = 0; i < n; i++) start.add(new Vertex(i + 1, A[0][i]));
        graph[0] = start;
        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j < n; j++) {
                LinkedList<Vertex> v = new LinkedList<Vertex>();
                if(j > 0) { // down left
                    int left = (i + 1) * n + j;
                    v.add(new Vertex(left, A[i + 1][j - 1]));
                }

                // down
                int down = (i + 1) * n + j + 1;
                v.add(new Vertex(down, A[i + 1][j]));

                if(j < n - 1) { // down right
                    int right = (i + 1) * n + j + 2;
                    v.add(new Vertex(right, A[i + 1][j + 1]));
                }
                graph[i * n + j + 1] = v;
            }
        }

        for(int i = 0; i < n; i++) {
            LinkedList<Vertex> end = new LinkedList<Vertex>();
            end.add(new Vertex(n * n + 1, 0));
            graph[(n - 1) * n + i + 1] = end;
        }
        graph[n * n + 1] = new LinkedList<Vertex>();
        Integer[] distances = shortestPath(graph, 0);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < distances.length; i++) {
            min = Math.min(min, distances[i]);
        }
        Integer[] b = Arrays.stream( new int[]{} ).boxed().toArray( Integer[]::new );
        Arrays.sort(b, Comparator.reverseOrder());
        return min;
    }

    public Integer[] shortestPath(LinkedList<Vertex>[] graph, int s) {
        Integer[] parents = new Integer[graph.length];
        boolean[] processed = new boolean[graph.length];
        Integer[] distances = new Integer[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (i == s) distances[i] = 0;
            else distances[i] = 100000;
        }
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(0);

        while (!queue.isEmpty()) {
            Integer v = queue.poll();
            processed[v] = true;
            for (Vertex u : graph[v]) {
                if (!processed[u.index] && distances[v] + u.weight < distances[u.index]) {
                    distances[u.index] = distances[v] + u.weight;
                    parents[u.index] = v;
                    queue.add(u.index);
                }
            }
        }

        return distances;
    }
}
class Vertex {
    int index;
    int weight;

    public Vertex(int index, int weight) {
        this.index = index;
        this.weight = weight;
    }
}
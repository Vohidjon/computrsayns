package graphs;

import java.util.*;

public class Traversal {
    /**
     * Time: O(N + M)
     * Recursive version
     * Uses adjacency list
     *
     * @param graph
     */
    public static void DFSRecursive(LinkedList<Integer>[] graph) {
        Integer[] parents = new Integer[graph.length];
        boolean[] processed = new boolean[graph.length];
        // run the algorithm on every vertex, so all vertices are traversed
        for (int i = 0; i < graph.length; i++) {
            if (!processed[i]) {
                DFSRecursive(graph, i, parents, processed);
            }
        }
    }

    private static void DFSRecursive(LinkedList<Integer>[] graph, int v, Integer[] parents, boolean[] processed) {
        processed[v] = true;
        System.out.println("Started vertex: " + v);
        for (Integer u : graph[v]) {
            if (!processed[u]) {
                parents[u] = v;
                DFSRecursive(graph, u, parents, processed);
            }
        }
    }

    /**
     * Time: O(N + M)
     * Iterative version
     * Uses adjacency list
     *
     * @param graph
     */
    public static void DFSIterative(LinkedList<Integer>[] graph) {
        Integer[] parents = new Integer[graph.length];
        boolean[] processed = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < graph.length; i++) {
            stack.push(i);
            while (!stack.isEmpty()) {
                Integer v = stack.pop();
                if (!processed[v]) {
                    processed[v] = true;
                    System.out.println("Started vertex: " + v);
                    for (Integer u : graph[v]) {
                        if (!processed[u]) {
                            stack.push(u);
                            parents[u] = v;
                        }
                    }
                }
            }
        }
    }

    /**
     * Time: O(N + M)
     * Recursive version
     * Uses adjacency matrix
     *
     * @param graph
     */

    public static void DFSRecursive(byte[][] graph) {
        Integer[] parents = new Integer[graph.length];
        boolean[] processed = new boolean[graph.length];
        for (int v = 0; v < graph.length; v++) {
            if (!processed[v]) {
                DFSRecursive(graph, v, parents, processed);
            }
        }
    }

    private static void DFSRecursive(byte[][] graph, int v, Integer[] parents, boolean[] processed) {
        processed[v] = true;
        System.out.println("Started vertex: " + v);
        for (int u = 0; u < graph[v].length; u++) {
            if (graph[v][u] == 1 && !processed[u]) {
                parents[u] = v;
                DFSRecursive(graph, u, parents, processed);
            }
        }
    }

    /**
     * Time: O(N + M)
     * Iterative version
     * Uses adjacency matrix
     *
     * @param graph
     */
    public static void DFSIterative(byte[][] graph) {
        Integer[] parents = new Integer[graph.length];
        boolean[] processed = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < graph.length; i++) {
            stack.push(i);
            while (!stack.isEmpty()) {
                Integer v = stack.pop();
                if (!processed[v]) {
                    processed[v] = true;
                    System.out.println("Started vertex: " + v);
                    for (int u = 0; u < graph[v].length; u++) {
                        if (graph[v][u] == 1 && !processed[u]) {
                            stack.push(u);
                            parents[u] = v;
                        }
                    }
                }
            }
        }
    }

    public static void BFS(LinkedList<Integer>[] graph) {
        Integer[] parents = new Integer[graph.length];
        boolean[] processed = new boolean[graph.length];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (!processed[i]) {
                queue.addLast(i);
                while (!queue.isEmpty()) {
                    Integer v = queue.removeFirst();
                    if (!processed[v]) {
                        processed[v] = true;
                        System.out.println("Started vertex: " + v);
                        for (Integer u : graph[v]) {
                            if (!processed[u]) {
                                parents[u] = v;
                                queue.addLast(u);
                            }
                        }
                    }
                }
            }
        }
    }

    public static void BFS(byte[][] graph) {
        Integer[] parents = new Integer[graph.length];
        boolean[] processed = new boolean[graph.length];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (!processed[i]) {
                queue.addLast(i);
                while (!queue.isEmpty()) {
                    Integer v = queue.removeFirst();
                    if(!processed[v]) {
                        processed[v] = true;
                        System.out.println("Started vertex: " + v);
                        for (int u = 0; u < graph[v].length; u++) {
                            if(graph[v][u] == 1 && !processed[u]) {
                                parents[u] = v;
                                queue.addLast(u);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Single-source shortest path - Dijkstra's algorithm
     * Time: O((N + M)(lgN))
     * logN, because we are using priority queue that takes logN to get min value
     * @param graph
     * @param s
     * @return
     */

    public static Integer[][] shortestPath(LinkedList<Vertex>[] graph, int s) {
        Integer[] parents = new Integer[graph.length];
        boolean[] processed = new boolean[graph.length];
        Integer[] distances = new Integer[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(i == s) distances[i] = 0;
            else distances[i] = Integer.MAX_VALUE;
        }
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(0);

        while (!queue.isEmpty()) {
            Integer v = queue.poll();
            processed[v] = true;
            for (Vertex u : graph[v]) {
                if(!processed[u.index] && distances[v] + u.weight < distances[u.index]) {
                    distances[u.index] = distances[v] + u.weight;
                    parents[u.index] = v;
                    queue.add(u.index);
                }
            }
        }

        return new Integer[][]{ parents, distances};
    }

    public static Integer[] minimumSpanningTree(LinkedList<Vertex>[] graph) {
        Integer[] parents = new Integer[graph.length];
        boolean[] processed = new boolean[graph.length];
        boolean[] discovered = new boolean[graph.length];
        Queue<Vertex> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        queue.add(new Vertex(1, 0));
        discovered[1] = true;
        while (!queue.isEmpty()) {
            Vertex v = queue.poll();
            processed[v.index] = true;
            for (Vertex u : graph[v.index]) {
                if(!discovered[u.index]) {
                    parents[u.index] = v.index;
                    discovered[u.index] = true;
                    queue.add(u);
                }
            }
        }

        return parents;
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
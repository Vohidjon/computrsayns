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
    public static void DFSRecursive(LinkedList<Vertex>[] graph) {
        Integer[] parents = new Integer[graph.length];
        boolean[] processed = new boolean[graph.length];
        // run the algorithm on every vertex, so all vertices are traversed
        for (int i = 0; i < graph.length; i++) {
            if (!processed[i]) {
                DFSRecursive(graph, i, parents, processed);
            }
        }
    }

    private static void DFSRecursive(LinkedList<Vertex>[] graph, int v, Integer[] parents, boolean[] processed) {
        processed[v] = true;
        System.out.println("Started vertex: " + v);
        for (Vertex u : graph[v]) {
            if (!processed[u.index]) {
                parents[u.index] = v;
                DFSRecursive(graph, u.index, parents, processed);
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
                    if (!processed[v]) {
                        processed[v] = true;
                        System.out.println("Started vertex: " + v);
                        for (int u = 0; u < graph[v].length; u++) {
                            if (graph[v][u] == 1 && !processed[u]) {
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
     *
     * @param graph
     * @param s
     * @return
     */

    public static Integer[][] shortestPath(LinkedList<Vertex>[] graph, int s) {
        Integer[] parents = new Integer[graph.length];
        boolean[] processed = new boolean[graph.length];
        Integer[] distances = new Integer[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (i == s) distances[i] = 0;
            else distances[i] = Integer.MAX_VALUE;
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

        return new Integer[][]{parents, distances};
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
                if (!discovered[u.index]) {
                    parents[u.index] = v.index;
                    discovered[u.index] = true;
                    queue.add(u);
                }
            }
        }

        return parents;
    }

    /**
     * Time: O(N + M)
     * Extends basic DFS to identify cycles
     * Main idea: when some vertex u is encountered and already processed,
     * backtrack the parents array to see if it is a cycle
     * Uses Adjacency list
     *
     * @param graph
     * @return
     */
    public static boolean checkForCycles(LinkedList<Vertex>[] graph) {
        Integer[] parents = new Integer[graph.length];
        boolean[] processed = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < graph.length; i++) {
            if (!processed[i]) stack.push(i);
            while (!stack.isEmpty()) {
                Integer v = stack.pop();
                if (!processed[v]) {
                    processed[v] = true;
                    for (Vertex u : graph[v]) {
                        if (!processed[u.index]) {
                            stack.push(u.index);
                            parents[u.index] = v;
                        } else { // possible cycle
                            Integer parent = parents[v];
                            while (parent != null) {
                                if (parent == u.index) return true; // has cycle
                                parent = parents[parent];
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * Topological Sort
     * Time: O(N + M)
     * Main idea: extend DFS to record finishing order of vertices and reverse the order to get a topological sort
     * Note: there could be more than one such order, depends on the order of processing vertex's edges
     *
     * @param graph
     * @return
     */
    public static Integer[] topologicalSort(LinkedList<Vertex>[] graph) {
        Integer[] parents = new Integer[graph.length];
        boolean[] processed = new boolean[graph.length];
        Stack<Integer> tpOrder = new Stack<>();
        // run the algorithm on every vertex, so all vertices are traversed
        for (int i = 0; i < graph.length; i++) {
            if (!processed[i]) {
                topologicalSort(graph, i, parents, processed, tpOrder);
            }
        }
        int j = 0;
        Integer[] result = new Integer[graph.length];
        while (!tpOrder.isEmpty()) {
            result[j++] = tpOrder.pop();
        }
        return result;
    }

    private static void topologicalSort(LinkedList<Vertex>[] graph, int v, Integer[] parents, boolean[] processed, Stack<Integer> tpOrder) {
        processed[v] = true;
        System.out.println("Started vertex: " + v);
        for (Vertex u : graph[v]) {
            if (!processed[u.index]) {
                parents[u.index] = v;
                topologicalSort(graph, u.index, parents, processed, tpOrder);
            }
        }
        tpOrder.push(v);
    }

    /**
     * Counts number of connected components
     * Main idea: run DFS on every vertex and keep the count when new search
     * Time: O(N + M)
     *
     * @param graph
     * @return
     */
    public static int countConnectedComponents(LinkedList<Vertex>[] graph) {
        int count = 0;
        Integer[] parents = new Integer[graph.length];
        boolean[] processed = new boolean[graph.length];
        // run the algorithm on every vertex, so all vertices are traversed
        for (int i = 0; i < graph.length; i++) {
            if (!processed[i]) {
                count++;
                DFSRecursive(graph, i, parents, processed);
            }
        }
        return count;
    }

    /**
     * List strongly connected components
     */
    public static int[] listStronglyConnectedComponents(LinkedList<Vertex>[] graph) {
        int[] components = new int[graph.length];
        Integer[] parents = new Integer[graph.length];
        Stack<Integer> order = new Stack<>();
        boolean[] processed = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(!processed[i]) {
                topologicalSort(graph, i, parents, processed, order);
            }
        }
        LinkedList<Vertex>[] reverseGraph = new LinkedList[graph.length];
        for (int i = 0; i < graph.length; i++) {
            reverseGraph[i] = new LinkedList<>();
        }
        for (int i = 0; i < graph.length; i++) {
            for (Vertex u : graph[i]) {
                reverseGraph[u.index].add(new Vertex(i, -1));
            }
        }
        int count = 1;
        processed = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>();
        while (!order.isEmpty()) {
            int i = order.pop();
            if(!processed[i]) {
                stack.push(i);
                while (!stack.isEmpty()) {
                    Integer v = stack.pop();
                    if (!processed[v]) {
                        processed[v] = true;
                        components[v] = count;
                        for (Vertex u : reverseGraph[v]) {
                            if (!processed[u.index]) {
                                stack.push(u.index);
                            }
                        }
                    }
                }
                count++;
            }
        }
        return components;
    }

    public static boolean isBipartite(LinkedList<Vertex>[] graph) {

        return false;
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
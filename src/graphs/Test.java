package graphs;

import java.util.Collections;
import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        LinkedList<Vertex>[] graph = new LinkedList[7];
        graph[0] = new LinkedList<>();
        Collections.addAll(graph[0], new Vertex(1, 2), new Vertex(2, 5), new Vertex(3, 2));
        graph[1] = new LinkedList<>();
        Collections.addAll(graph[1], new Vertex(0, 2), new Vertex(4, 3), new Vertex(5, 1));
        graph[2] = new LinkedList<>();
        Collections.addAll(graph[2], new Vertex(0, 5), new Vertex(6, 6));
        graph[3] = new LinkedList<>();
        Collections.addAll(graph[3], new Vertex(0, 2), new Vertex(6, 4));
        graph[4] = new LinkedList<>();
        Collections.addAll(graph[4], new Vertex(1, 3), new Vertex(5, 2));
        graph[5] = new LinkedList<>();
        Collections.addAll(graph[5], new Vertex(4, 2), new Vertex(1, 1), new Vertex(6, 4));
        graph[6] = new LinkedList<>();
        Collections.addAll(graph[6], new Vertex(2, 6), new Vertex(3, 4), new Vertex(5, 4));

        Integer[] result = Traversal.minimumSpanningTree(graph);

//        Traversal.BFS(graph);

        byte[][] matrix = new byte[][]{
                ////////// 0  1  2  3  4  5  6  7  8
                new byte[]{0, 1, 1, 1, 0, 0, 0, 0, 0}, // 0
                new byte[]{0, 0, 0, 0, 1, 1, 0, 0, 0}, // 1
                new byte[]{0, 0, 0, 0, 0, 0, 1, 0, 0}, // 2
                new byte[]{0, 0, 0, 0, 0, 0, 1, 0, 0}, // 3
                new byte[]{0, 0, 0, 0, 0, 1, 0, 0, 0}, // 4
                new byte[]{0, 0, 0, 0, 0, 0, 1, 0, 0}, // 5
                new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0}, // 6
                new byte[]{0, 0, 0, 0, 0, 0, 1, 0, 1}, // 7
                new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0}, // 8
        };

//        Traversal.BFS(matrix);
    }
}

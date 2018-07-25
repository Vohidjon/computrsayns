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

        LinkedList<Vertex>[] graphWithCycle = new LinkedList[7];
        graphWithCycle[0] = new LinkedList<>();
        Collections.addAll(graphWithCycle[0], new Vertex(2, -1), new Vertex(3, -1));
        graphWithCycle[1] = new LinkedList<>();
        Collections.addAll(graphWithCycle[1], new Vertex(0, -1), new Vertex(4, -1), new Vertex(5, -1));
        graphWithCycle[2] = new LinkedList<>();
        Collections.addAll(graphWithCycle[2], new Vertex(6, -1));
        graphWithCycle[3] = new LinkedList<>();
        Collections.addAll(graphWithCycle[3], new Vertex(6, -1));
        graphWithCycle[4] = new LinkedList<>();
        Collections.addAll(graphWithCycle[4], new Vertex(5, -1));
        graphWithCycle[5] = new LinkedList<>();
        Collections.addAll(graphWithCycle[5], new Vertex(6, -1));
        graphWithCycle[6] = new LinkedList<>();


        LinkedList<Vertex>[] graphWithCrossEdge = new LinkedList[5];
        graphWithCrossEdge[0] = new LinkedList<>();
        Collections.addAll(graphWithCrossEdge[0], new Vertex(1, -1), new Vertex(2, -1), new Vertex(3, -1), new Vertex(4, -1));
        graphWithCrossEdge[1] = new LinkedList<>();
        Collections.addAll(graphWithCrossEdge[1], new Vertex(2, -1), new Vertex(3, -1));
        graphWithCrossEdge[2] = new LinkedList<>();
        Collections.addAll(graphWithCrossEdge[2], new Vertex(3, -1), new Vertex(4, -1));
        graphWithCrossEdge[3] = new LinkedList<>();
        Collections.addAll(graphWithCrossEdge[3], new Vertex(4, -1));
        graphWithCrossEdge[4] = new LinkedList<>();
        Collections.addAll(graphWithCrossEdge[4]);

//        Integer res = Traversal.countConnectedComponents(graph);
        LinkedList<Vertex>[] graphForSCC = new LinkedList[12];
        graphForSCC[0] = new LinkedList<>();
        Collections.addAll(graphForSCC[0], new Vertex(1, -1));
        graphForSCC[1] = new LinkedList<>();
        Collections.addAll(graphForSCC[1], new Vertex(3, -1));
        graphForSCC[2] = new LinkedList<>();
        Collections.addAll(graphForSCC[2], new Vertex(0, -1));
        graphForSCC[3] = new LinkedList<>();
        Collections.addAll(graphForSCC[3], new Vertex(2, -1), new Vertex(4, -1));
        graphForSCC[4] = new LinkedList<>();
        Collections.addAll(graphForSCC[4], new Vertex(5, -1));
        graphForSCC[5] = new LinkedList<>();
        Collections.addAll(graphForSCC[5], new Vertex(6, -1));
        graphForSCC[6] = new LinkedList<>();
        Collections.addAll(graphForSCC[6], new Vertex(4, -1), new Vertex(7, -1));
        graphForSCC[7] = new LinkedList<>();
        Collections.addAll(graphForSCC[7], new Vertex(8, -1), new Vertex(9, -1));
        graphForSCC[8] = new LinkedList<>();
        Collections.addAll(graphForSCC[8], new Vertex(10, -1));
        graphForSCC[9] = new LinkedList<>();
        Collections.addAll(graphForSCC[9], new Vertex(8, -1));
        graphForSCC[10] = new LinkedList<>();
        Collections.addAll(graphForSCC[10], new Vertex(10, -1), new Vertex(11, -1));
        graphForSCC[11] = new LinkedList<>();
        Collections.addAll(graphForSCC[11]);

        LinkedList<Vertex>[] bipartiteGraph = new LinkedList[8];
        bipartiteGraph[0] = new LinkedList<>();
        Collections.addAll(bipartiteGraph[0], new Vertex(4, -1), new Vertex(5, -1), new Vertex(2, -1));
        bipartiteGraph[1] = new LinkedList<>();
        Collections.addAll(bipartiteGraph[1], new Vertex(4, -1), new Vertex(5, -1), new Vertex(6, -1), new Vertex(7, -1));
        bipartiteGraph[2] = new LinkedList<>();
        Collections.addAll(bipartiteGraph[2], new Vertex(7, -1), new Vertex(0, -1));
        bipartiteGraph[3] = new LinkedList<>();
        Collections.addAll(bipartiteGraph[3], new Vertex(5, -1), new Vertex(7, -1));
        bipartiteGraph[4] = new LinkedList<>();
        Collections.addAll(bipartiteGraph[4], new Vertex(0, -1), new Vertex(1, -1));
        bipartiteGraph[5] = new LinkedList<>();
        Collections.addAll(bipartiteGraph[5], new Vertex(0, -1), new Vertex(1, -1), new Vertex(3, -1));
        bipartiteGraph[6] = new LinkedList<>();
        Collections.addAll(bipartiteGraph[6], new Vertex(1, -1));
        bipartiteGraph[7] = new LinkedList<>();
        Collections.addAll(bipartiteGraph[7], new Vertex(1, -1), new Vertex(2, -1), new Vertex(3, -1));
//        System.out.println(Traversal.isBipartite(bipartiteGraph));


    }
}

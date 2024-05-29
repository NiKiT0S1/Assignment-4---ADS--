/**
 * BreadthFirstSearch implements the breadth-first search algorithm for unweighted graphs.
 * It extends the Search class and uses a queue to explore vertices level by level.
 */
import java.util.*;

public class BreadthFirstSearch<Vertex> extends Search<Vertex> {
    /**
     * Constructor to initialize the BFS with a given graph and source vertex.
     * @param graph The graph to search
     * @param source The source vertex
     */
    public BreadthFirstSearch(MyGraph<Vertex> graph, Vertex source) {
        super(source);
        bfs(graph, source);
    }

    /**
     * Performs the breadth-first search algorithm.
     * @param graph The graph to search
     * @param source The source vertex
     */
    private void bfs(MyGraph<Vertex> graph, Vertex source) {
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(source);
        marked.add(source);
        while (!queue.isEmpty()) {
            Vertex v = queue.poll();
            for (Vertex w : graph.adjacencyList(v)) {
                if (!marked.contains(w)) {
                    edgeTo.put(w, v);
                    marked.add(w);
                    queue.add(w);
                }
            }
        }
    }
}
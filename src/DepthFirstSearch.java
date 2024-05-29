/**
 * DepthFirstSearch implements the depth-first search algorithm for unweighted graphs.
 * It extends the Search class and uses recursion to explore vertices deeply before backtracking.
 */
import java.util.*;

public class DepthFirstSearch<Vertex> extends Search<Vertex> {
    /**
     * Constructor to initialize the DFS with a given graph and source vertex.
     * @param graph The graph to search
     * @param source The source vertex
     */
    public DepthFirstSearch(MyGraph<Vertex> graph, Vertex source) {
        super(source);
        dfs(graph, source);
    }

    /**
     * Performs the depth-first search algorithm.
     * @param graph The graph to search
     * @param v The current vertex being explored
     */
    private void dfs(MyGraph<Vertex> graph, Vertex v) {
        marked.add(v);
        for (Vertex w : graph.adjacencyList(v)) {
            if (!marked.contains(w)) {
                edgeTo.put(w, v);
                dfs(graph, w);
            }
        }
    }
}
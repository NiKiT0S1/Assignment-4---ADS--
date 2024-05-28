import java.util.*;

public class DepthFirstSearch<Vertex> extends Search<Vertex> {
    public DepthFirstSearch(MyGraph<Vertex> graph, Vertex source) {
        super(source);
        dfs(graph, source);
    }

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


/**
 * Search is a base class for graph search algorithms. It holds the data structures used during the search process.
 * It provides methods to check if a path exists and to retrieve the path from the source to a given vertex.
 */
import java.util.*;

public class Search<Vertex> {
    protected Set<Vertex> marked; // Set of visited vertices
    protected Map<Vertex, Vertex> edgeTo; // Map to track paths
    protected final Vertex source; // Source vertex for the search

    /**
     * Constructor to initialize the search with a given source vertex.
     * @param source The source vertex
     */
    public Search(Vertex source) {
        this.source = source;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
    }

    /**
     * Checks if there is a path to a given vertex.
     * @param v The vertex to check
     * @return True if there is a path, false otherwise
     */
    public boolean hasPathTo(Vertex v) {
        return marked.contains(v);
    }

    /**
     * Retrieves the path from the source to a given vertex.
     * @param v The vertex to get the path to
     * @return An iterable of vertices representing the path, or null if no path exists
     */
    public Iterable<Vertex> pathTo(Vertex v) {
        if (!hasPathTo(v)) {
            return null;
        }

        LinkedList<Vertex> path = new LinkedList<>();
        for (Vertex i = v; i != source; i = edgeTo.get(i)) {
            path.push(i);
        }

        path.push(source);
        return path;
    }
}
/**
 * MyGraph represents an unweighted graph. It can be directed or undirected based on the constructor parameter.
 * It provides methods to add vertices and edges, and to query the graph's structure.
 */
import java.util.*;

public class MyGraph<Vertex> {
    private final boolean undirected;
    private final Map<Vertex, List<Vertex>> map = new HashMap<>();

    /**
     * Default constructor for creating an undirected graph.
     */
    public MyGraph() {
        this(true);
    }

    /**
     * Constructor for creating a graph with a specified direction.
     * @param undirected Boolean indicating whether the graph is undirected
     */
    public MyGraph(boolean undirected) {
        this.undirected = undirected;
    }

    /**
     * Adds a vertex to the graph if it does not already exist.
     * @param v The vertex to add
     */
    public void addVertex(Vertex v) {
        if (hasVertex(v))
            return;

        map.put(v, new LinkedList<>());
    }

    /**
     * Adds an edge between two vertices. If the graph is undirected, adds an edge in both directions.
     * @param source The source vertex
     * @param dest The destination vertex
     */
    public void addEdge(Vertex source, Vertex dest) {
        if (!hasVertex(source))
            addVertex(source);

        if (!hasVertex(dest))
            addVertex(dest);

        if (hasEdge(source, dest) || source.equals(dest))
            return; // reject parallels & self-loops

        map.get(source).add(dest);

        if (undirected)
            map.get(dest).add(source);
    }

    /**
     * Returns the number of vertices in the graph.
     * @return The number of vertices
     */
    public int getVerticesCount() {
        return map.size();
    }

    /**
     * Returns the number of edges in the graph.
     * @return The number of edges
     */
    public int getEdgesCount() {
        int count = 0;
        for (Vertex v : map.keySet()) {
            count += map.get(v).size();
        }

        if (undirected)
            count /= 2;

        return count;
    }

    /**
     * Checks if the graph contains a specific vertex.
     * @param v The vertex to check
     * @return True if the vertex exists, false otherwise
     */
    public boolean hasVertex(Vertex v) {
        return map.containsKey(v);
    }

    /**
     * Checks if there is an edge between two vertices.
     * @param source The source vertex
     * @param dest The destination vertex
     * @return True if the edge exists, false otherwise
     */
    public boolean hasEdge(Vertex source, Vertex dest) {
        if (!hasVertex(source)) return false;
        return map.get(source).contains(dest);
    }

    /**
     * Returns the adjacency list of a given vertex.
     * @param v The vertex to get the adjacency list for
     * @return The adjacency list of the vertex
     */
    public List<Vertex> adjacencyList(Vertex v) {
        if (!hasVertex(v)) return null;
        return map.get(v);
    }
}
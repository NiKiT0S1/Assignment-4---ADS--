/**
 * WeightedGraph represents a weighted graph. It can be directed or undirected based on the constructor parameter.
 * It provides methods to add vertices and edges with weights, and to query the graph's structure.
 */
import java.util.*;

public class WeightedGraph<Vertex> {
    private final boolean undirected; // Indicates if the graph is undirected
    private final Map<Vertex, Map<Vertex, Double>> map = new HashMap<>(); // Graph representation

    /**
     * Default constructor for creating an undirected weighted graph.
     */
    public WeightedGraph() {
        this(true);
    }

    /**
     * Constructor for creating a weighted graph with a specified direction.
     * @param undirected Boolean indicating whether the graph is undirected
     */
    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    /**
     * Adds a vertex to the graph if it does not already exist.
     * @param v The vertex to add
     */
    public void addVertex(Vertex v) {
        map.putIfAbsent(v, new HashMap<>());
    }

    /**
     * Adds a weighted edge between two vertices. If the graph is undirected, adds an edge in both directions.
     * @param source The source vertex
     * @param dest The destination vertex
     * @param weight The weight of the edge
     */
    public void addEdge(Vertex source, Vertex dest, double weight) {
        addVertex(source);
        addVertex(dest);

        map.get(source).put(dest, weight);
        if (undirected) {
            map.get(dest).put(source, weight);
        }
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
        for (Map<Vertex, Double> edges : map.values()) {
            count += edges.size();
        }

        if (undirected) {
            count /= 2;
        }

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
     * Checks if there is a weighted edge between two vertices.
     * @param source The source vertex
     * @param dest The destination vertex
     * @return True if the edge exists, false otherwise
     */
    public boolean hasEdge(Vertex source, Vertex dest) {
        return map.containsKey(source) && map.get(source).containsKey(dest);
    }

    /**
     * Returns the map of adjacent vertices with their corresponding edge weights.
     * @param v The vertex to get the adjacency map for
     * @return The map of adjacent vertices
     */
    public Map<Vertex, Double> getAdjacentVertices(Vertex v) {
        return map.getOrDefault(v, new HashMap<>());
    }

    /**
     * Prints the graph in a readable format, showing each vertex and its connections with weights.
     */
    public void printGraph() {
        for (Map.Entry<Vertex, Map<Vertex, Double>> entry : map.entrySet()) {
            System.out.print("Vertex " + entry.getKey() + " is connected to: ");
            for (Map.Entry<Vertex, Double> e : entry.getValue().entrySet()) {
                System.out.print(e.getKey() + " (weight " + e.getValue() + "), ");
            }
            System.out.println();
        }
    }
}
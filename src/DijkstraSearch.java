/**
 * DijkstraSearch implements Dijkstra's algorithm for finding the shortest path in weighted graphs.
 * It extends the Search class and uses a priority queue to explore vertices based on their current shortest distance.
 */
import java.util.*;

public class DijkstraSearch<Vertex> extends Search<Vertex> {
    private final Map<Vertex, Double> distTo; // Map to track shortest distances to vertices
    private final PriorityQueue<Vertex> pq; // Priority queue to explore vertices

    /**
     * Constructor to initialize Dijkstra's algorithm with a given weighted graph and source vertex.
     * @param graph The weighted graph to search
     * @param source The source vertex
     */
    public DijkstraSearch(WeightedGraph<Vertex> graph, Vertex source) {
        super(source);
        distTo = new HashMap<>();
        pq = new PriorityQueue<>(Comparator.comparing(distTo::get));

        for (Vertex v : graph.getAdjacentVertices(source).keySet()) {
            distTo.put(v, Double.POSITIVE_INFINITY);
        }

        distTo.put(source, 0.0);
        pq.add(source);

        while (!pq.isEmpty()) {
            Vertex v = pq.poll();
            for (Map.Entry<Vertex, Double> entry : graph.getAdjacentVertices(v).entrySet()) {
                relax(v, entry.getKey(), entry.getValue());
            }
        }
    }

    /**
     * Relaxes an edge, updating the shortest path to the destination vertex if a shorter path is found.
     * @param v The source vertex
     * @param w The destination vertex
     * @param weight The weight of the edge
     */
    private void relax(Vertex v, Vertex w, double weight) {
        distTo.putIfAbsent(w, Double.POSITIVE_INFINITY);
        double distThroughV = distTo.get(v) + weight;
        if (distTo.get(w) > distThroughV) {
            distTo.put(w, distThroughV);
            edgeTo.put(w, v);
            if (pq.contains(w)) {
                pq.remove(w);
            }
            pq.add(w);
        }
    }
}
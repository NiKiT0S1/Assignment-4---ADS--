import java.util.*;

public class DijkstraSearch<Vertex> extends Search<Vertex> {
    private final Map<Vertex, Double> distTo;
    private final PriorityQueue<Vertex> pq;

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

    private void relax(Vertex v, Vertex w, double weight) {
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

import java.util.*;

public class WeightedGraph<Vertex> {
    private final boolean undirected;
    private final Map<Vertex, Map<Vertex, Double>> map = new HashMap<>();

    public WeightedGraph() {
        this(true);
    }

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(Vertex v) {
        map.putIfAbsent(v, new HashMap<>());
    }

    public void addEdge(Vertex source, Vertex dest, double weight) {
        addVertex(source);
        addVertex(dest);

        map.get(source).put(dest, weight);
        if (undirected) {
            map.get(dest).put(source, weight);
        }
    }

    public int getVerticesCount() {
        return map.size();
    }

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

    public boolean hasVertex(Vertex v) {
        return map.containsKey(v);
    }

    public boolean hasEdge(Vertex source, Vertex dest) {
        return map.containsKey(source) && map.get(source).containsKey(dest);
    }

    public Map<Vertex, Double> getAdjacentVertices(Vertex v) {
        return map.get(v);
    }

    public void printGraph() {
        for (Map.Entry<Vertex, Map<Vertex, Double>> entry : map.entrySet()) {
            System.out.print("Vertex: " + entry.getKey() + "is connected to: ");
            for (Map.Entry<Vertex, Double> e : entry.getValue().entrySet()) {
                System.out.print(e.getKey() + " (weight " + e.getValue() + "), ");
            }
            System.out.println();
        }
    }
}

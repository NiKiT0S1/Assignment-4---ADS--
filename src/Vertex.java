/**
 * Vertex represents a vertex in a weighted graph. It holds the data and a map of adjacent vertices with corresponding edge weights.
 * It provides methods to add adjacent vertices, get and set data, and override equality and hash code methods.
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Vertex<T> {
    private T data; // Data stored in the vertex
    private Map<Vertex<T>, Double> adjacentVertices; // Adjacent vertices with weights

    /**
     * Constructor to create a new vertex with the given data.
     * @param data The data stored in the vertex
     */
    public Vertex(T data) {
        this.data = data;
        this.adjacentVertices = new HashMap<>();
    }

    /**
     * Getter method to retrieve the data of the vertex.
     * @return The data of the vertex
     */
    public T getData() {
        return data;
    }

    /**
     * Setter method to set the data of the vertex.
     * @param data The new data to set
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Adds an adjacent vertex with the given weight.
     * @param destination The adjacent vertex
     * @param weight The weight of the edge
     */
    public void addAdjacentVertex(Vertex<T> destination, double weight) {
        adjacentVertices.put(destination, weight);
    }

    /**
     * Returns the map of adjacent vertices with their corresponding edge weights.
     * @return The map of adjacent vertices
     */
    public Map<Vertex<T>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }

    /**
     * Sets the map of adjacent vertices with their corresponding edge weights.
     * @param adjacentVertices The new map of adjacent vertices
     */
    public void setAdjacentVertices(Map<Vertex<T>, Double> adjacentVertices) {
        this.adjacentVertices = adjacentVertices;
    }

    /**
     * Overrides the equals method to compare vertices based on their data.
     * @param o The object to compare with
     * @return True if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vertex<?> vertex = (Vertex<?>) o;
        return Objects.equals(data, vertex.data);
    }

    /**
     * Overrides the hashCode method to provide a hash code based on the vertex data.
     * @return The hash code of the vertex
     */
    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    /**
     * Overrides the toString method to return the string representation of the vertex data.
     * @return The string representation of the vertex data
     */
    @Override
    public String toString() {
        return data.toString();
    }
}
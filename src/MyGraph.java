import java.util.*;

public class MyGraph<Vertex> {
    private final boolean undirected;
    private final Map<Vertex, List<Vertex>> map = new HashMap<>();

    public MyGraph() {
        this(true);
    }

    public MyGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(Vertex v) {
        if (hasVertex(v))
            return;

        map.put(v, new LinkedList<>());
    }

    public void addEdge(Vertex source, Vertex dest) {
        if (!hasVertex(source))
            addVertex(source);

        if (!hasVertex(dest))
            addVertex(dest);

        if (hasEdge(source, dest)
                || source.equals(dest))
            return; // reject parallels & self-loops

        map.get(source).add(dest);

        if (undirected)
            map.get(dest).add(source);
    }

    public int getVerticesCount() {
        return map.size();
    }

    public int getEdgesCount() {
        int count = 0;
        for (Vertex v : map.keySet()) {
            count += map.get(v).size();
        }

        if (undirected)
            count /= 2;

        return count;
    }


    public boolean hasVertex(Vertex v) {
        return map.containsKey(v);
    }

    public boolean hasEdge(Vertex source, Vertex dest) {
        if (!hasVertex(source)) return false;
        return map.get(source).contains(dest);
    }

    public List<Vertex> adjacencyList(Vertex v) {
        if (!hasVertex(v)) return null;

        return map.get(v);
    }


//    public static void main (String[] args) {
//        private int numOfVertices;
//        private LinkedList<Integer>[] adjList;
//
//    public MyGraph(int numOfVertices) {
//            this.numOfVertices = numOfVertices;
//            this.adjList = new LinkedList[numOfVertices];
//            for (int i = 0; i < numOfVertices; i++) {
//                adjList[i] = new LinkedList<Integer>();
//            }
//        }
//
//        public void addEdge(int source, int destination) {
//            validateVertex(source);
//            validateVertex(destination);
//            adjList[source].add(destination);
//            adjList[destination].add(source);
//        }
//
//        public boolean hasEdge(int source, int destination) {
//            validateVertex(source);
//            validateVertex(destination);
//            return adjList[source].contains(destination);
//        }
//
//        private void validateVertex(int index) {
//            if (index < 0 || index >= numOfVertices)
//                throw new IndexOutOfBoundsException("Vertex does not exist");
//        }
//
//        public void removeEdge(int source, int destination){
//            validateVertex(source);
//            validateVertex(destination);
//            adjList[source].remove(adjList[source].indexOf(destination));
//            adjList[destination].remove(adjList[destination].indexOf(source));
//        }
//
//        public LinkedList<Integer> getNeighbors(int vertex) {
//            validateVertex(vertex);
//            return adjList[vertex];
//        }
//
//        public void printGraph() {
//            for (int i = 0; i < numOfVertices; i++) {
//                System.out.print("Vertex " + i + " connected to " );
//                for (int neighbor : adjList[i]) {
//                    System.out.print(neighbor + " ");
//                }
//                System.out.println();
//            }
//    }
}

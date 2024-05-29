public class Main {
    public static void main(String[] args) {
        // Create a weighted graph
        WeightedGraph<String> weightedGraph = new WeightedGraph<>(true);
        fillWithWeights(weightedGraph);

        // Perform Dijkstra's algorithm and output the path
        System.out.println("Dijkstra:");
        Search<String> djk = new DijkstraSearch<>(weightedGraph, "Almaty");
        outputPath(djk, "Kyzylorda");

        System.out.println("--------------------------------");

        // Create an unweighted graph
        MyGraph<String> graph = new MyGraph<>(true);
        fillWithoutWeights(graph);

        // Perform Depth-First Search (DFS) and output the path
        System.out.println("DFS:");
        Search<String> dfs = new DepthFirstSearch<>(graph, "Almaty");
        outputPath(dfs, "Kyzylorda");

        System.out.println("--------------------------------");

        // Perform Breadth-First Search (BFS) and output the path
        System.out.println("BFS:");
        Search<String> bfs = new BreadthFirstSearch<>(graph, "Almaty");
        outputPath(bfs, "Kyzylorda");
    }

    // Fill the unweighted graph with edges
    public static void fillWithoutWeights(MyGraph<String> graph) {
        graph.addEdge("Almaty", "Astana");
        graph.addEdge("Shymkent", "Atyrau");
        graph.addEdge("Atyrau", "Astana");
        graph.addEdge("Almaty", "Shymkent");
        graph.addEdge("Shymkent", "Astana");
        graph.addEdge("Astana", "Kostanay");
        graph.addEdge("Shymkent", "Kyzylorda");
    }

    // Fill the weighted graph with edges and weights
    public static void fillWithWeights(WeightedGraph<String> graph) {
        graph.addEdge("Almaty", "Astana", 2.1);
        graph.addEdge("Shymkent", "Atyrau", 7.8);
        graph.addEdge("Atyrau", "Astana", 7.1);
        graph.addEdge("Almaty", "Shymkent", 7.2);
        graph.addEdge("Shymkent", "Astana", 3.9);
        graph.addEdge("Astana", "Kostanay", 3.5);
        graph.addEdge("Shymkent", "Kyzylorda", 5.4);
    }

    // Output the path to the specified vertex
    public static void outputPath(Search<String> search, String key) {
        Iterable<String> path = search.pathTo(key);
        if (path == null) {
            System.out.println("No path found to " + key);
        } else {
            for (String v : path) {
                System.out.print(v + " -> ");
            }
            System.out.println();
        }
    }
}
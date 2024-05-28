public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> weightedGraph = new WeightedGraph<>(true);
        fillWithWeights(weightedGraph);

        System.out.println("Dijkstra:");
        Search<String> djk = new DijkstraSearch<>(weightedGraph, "Almaty");
        outputPath(djk, "Kyzylorda");

        System.out.println("--------------------------------");

        MyGraph<String> graph = new MyGraph<>(true);
        fillWithoutWeights(graph);

        System.out.println("DFS:");
        Search<String> dfs = new DepthFirstSearch<>(graph, "Almaty");
        outputPath(dfs, "Kyzylorda");

        System.out.println("--------------------------------");

        System.out.println("BFS:");
        Search<String> bfs = new BreadthFirstSearch<>(graph, "Almaty");
        outputPath(bfs, "Kyzylorda");
    }

    public static void fillWithoutWeights(MyGraph<String> graph) {
        graph.addEdge("Almaty", "Astana");
        graph.addEdge("Shymkent", "Atyrau");
        graph.addEdge("Atyrau", "Astana");
        graph.addEdge("Almaty", "Shymkent");
        graph.addEdge("Shymkent", "Astana");
        graph.addEdge("Astana", "Kostanay");
        graph.addEdge("Shymkent", "Kyzylorda");
    }

    public static void fillWithWeights(WeightedGraph<String> graph) {
        graph.addEdge("Almaty", "Astana", 2.1);
        graph.addEdge("Shymkent", "Atyrau", 7.8);
        graph.addEdge("Atyrau", "Astana", 7.1);
        graph.addEdge("Almaty", "Shymkent", 7.2);
        graph.addEdge("Shymkent", "Astana", 3.9);
        graph.addEdge("Astana", "Kostanay", 3.5);
        graph.addEdge("Shymkent", "Kyzylorda", 5.4);
    }

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




//    public static void main (String[] args) {
//        MyGraph myGraph = new MyGraph(5);
//        myGraph.addEdge(0,1);
//        myGraph.addEdge(1,2);
//        myGraph.addEdge(2,4);
//        myGraph.addEdge(3,4);
//        myGraph.addEdge(3,1);
//
//        System.out.println(myGraph.hasEdge(2, 3));
//        System.out.println(myGraph.hasEdge(2, 4));
//        myGraph.removeEdge(2, 4);
//        System.out.println(myGraph.hasEdge(2,4));
//
//        System.out.println(myGraph.getNeighbors(1));
//
//        myGraph.printGraph();
//
//
//        MyGraph<String> graph = new MyGraph<>();
//
//        graph.addVertex("Almaty");
//        graph.addVertex("Astana");
//        graph.addVertex("Shymkent");
//        graph.addVertex("Pavlodar");
//        graph.addVertex("Oral");
//
//        graph.addEdge("Almaty","Astana");
//        graph.addEdge("Almaty","Shymkent");
//        graph.addEdge("Astana","Pavlodar");
//        graph.addEdge("Astana","Oral");
//
//
//        System.out.println(graph.hasEdge("Almaty", "Astana"));
//        System.out.println(graph.hasEdge("Almaty", "Pavlodar"));
//
//        System.out.println();
//
//        System.out.println(graph.getNeighbors("Almaty"));
//
//        graph.printGraph();
//        System.out.println("_____________________________");
//        graph.removeEdge("Astana", "Oral");
//
//        graph.printGraph();
//    }
}
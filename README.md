# ASSIGNMENT 4 -- DOCUMENTATION


## Main
`Main` - a class that serves as the entry point of the program, demonstrating the usage of various graph search algorithms and graph representations. It includes methods for populating graphs with and without weights, and outputs search results to the console.

### Methods:
- `main(String[] args)`: The main method that executes the program, demonstrating Dijkstra's, DFS, and BFS algorithms on sample graphs.
- `fillWithoutWeights(MyGraph<String> graph)`: Populates an unweighted graph with sample data.
- `fillWithWeights(WeightedGraph<String> graph)`: Populates a weighted graph with sample data.
- `outputPath(Search<String> search, String key)`: Outputs the path found by a search algorithm from the source to a specified key.

### Usage Example:
```java
// Demonstrating Dijkstra's algorithm on a weighted graph
WeightedGraph<String> weightedGraph = new WeightedGraph<>(true);
fillWithWeights(weightedGraph);
Search<String> djk = new DijkstraSearch<>(weightedGraph, "Almaty");
outputPath(djk, "Kyzylorda");

// Demonstrating DFS on an unweighted graph
MyGraph<String> graph = new MyGraph<>(true);
fillWithoutWeights(graph);
Search<String> dfs = new DepthFirstSearch<>(graph, "Almaty");
outputPath(dfs, "Kyzylorda");

// Demonstrating BFS on an unweighted graph
Search<String> bfs = new BreadthFirstSearch<>(graph, "Almaty");
outputPath(bfs, "Kyzylorda");
```


## MyGraph

`MyGraph` - a class representing an unweighted graph using an adjacency list. It supports directed or undirected graphs and provides methods to add vertices and edges, and to query the graph's structure.

### Methods:
- `MyGraph()`: Default constructor for an undirected graph.
- `MyGraph(boolean undirected)`: Constructor to specify if the graph is directed or undirected.
- `addVertex(Vertex v)`: Adds a vertex to the graph.
- `addEdge(Vertex source, Vertex dest)`: Adds an edge between two vertices.
- `getVerticesCount()`: Returns the number of vertices in the graph.
- `getEdgesCount()`: Returns the number of edges in the graph.
- `hasVertex(Vertex v)`: Checks if a vertex exists in the graph.
- `hasEdge(Vertex source, Vertex dest)`: Checks if an edge exists between two vertices.
- `adjacencyList(Vertex v)`: Returns the adjacency list of a vertex.

### Usage Examples:
```java
// Creating an instance of MyGraph
MyGraph<String> graph = new MyGraph<>(true);

// Adding vertices and edges
graph.addVertex("Almaty");
graph.addEdge("Almaty", "Astana");

// Checking for vertices and edges
boolean hasVertex = graph.hasVertex("Almaty"); // Returns true
boolean hasEdge = graph.hasEdge("Almaty", "Astana"); // Returns true
```


## Vertex

`Vertex` - a class representing a vertex in a weighted graph. It contains data and a map of adjacent vertices with edge weights.

### Methods:
- `Vertex(T data)`: Constructor to create a vertex with the given data.
- `getData()`: Retrieves the data of the vertex.
- `setData(T data)`: Sets the data of the vertex.
- `addAdjacentVertex(Vertex<T> destination, double weight)`: Adds an adjacent vertex with a specified weight.
- `getAdjacentVertices()`: Retrieves the map of adjacent vertices with their weights.
- `setAdjacentVertices(Map<Vertex<T>, Double> adjacentVertices)`: Sets the adjacent vertices map.

### Usage Example:
```java
// Creating an instance of Vertex
Vertex<String> vertex = new Vertex<>("Almaty");

// Adding adjacent vertices
vertex.addAdjacentVertex(new Vertex<>("Astana"), 2.1);

// Retrieving adjacent vertices
Map<Vertex<String>, Double> adjVertices = vertex.getAdjacentVertices();
```


## Search

`Search` - a base class for graph search algorithms. It holds data structures for marking visited vertices and storing the path from the source vertex to others.

### Methods:
```java
- `Search(Vertex source)`: Constructor initializing the search with the source vertex.
- `hasPathTo(Vertex v)`: Checks if there is a path to the specified vertex.
- `pathTo(Vertex v)`: Retrieves the path from the source to the specified vertex.

### Usage Examples:
// Creating an instance of a search algorithm (e.g., DFS)
Search<String> search = new DepthFirstSearch<>(new MyGraph<>(true), "Almaty");

// Checking if there is a path to a vertex
boolean hasPath = search.hasPathTo("Kyzylorda"); // Returns true or false

// Retrieving the path to a vertex
Iterable<String> path = search.pathTo("Kyzylorda");
```


## WeightedGraph

`WeightedGraph` - a class representing a weighted graph using an adjacency list. It supports directed or undirected graphs and provides methods to add vertices and weighted edges, and to query the graph's structure.

### Methods:
- `WeightedGraph()`: Default constructor for an undirected graph.
- `WeightedGraph(boolean undirected)`: Constructor to specify if the graph is directed or undirected.
- `addVertex(Vertex v)`: Adds a vertex to the graph.
- `addEdge(Vertex source, Vertex dest, double weight)`: Adds a weighted edge between two vertices.
- `getVerticesCount()`: Returns the number of vertices in the graph.
- `getEdgesCount()`: Returns the number of edges in the graph.
- `hasVertex(Vertex v)`: Checks if a vertex exists in the graph.
- `hasEdge(Vertex source, Vertex dest)`: Checks if a weighted edge exists between two vertices.
- `getAdjacentVertices(Vertex v)`: Retrieves the adjacent vertices and weights for a vertex.

### Usage Examples:
```java
// Creating an instance of WeightedGraph
WeightedGraph<String> weightedGraph = new WeightedGraph<>(true);

// Adding vertices and weighted edges
weightedGraph.addVertex("Almaty");
weightedGraph.addEdge("Almaty", "Astana", 2.1);

// Checking for vertices and edges
boolean hasVertex = weightedGraph.hasVertex("Almaty"); // Returns true
boolean hasEdge = weightedGraph.hasEdge("Almaty", "Astana"); // Returns true

// Retrieving adjacent vertices
Map<String, Double> adjVertices = weightedGraph.getAdjacentVertices("Almaty");
```


## BreadthFirstSearch

`BreadthFirstSearch` - a class implementing the breadth-first search algorithm for unweighted graphs. It extends the Search class and uses a queue to explore vertices level by level.

### Methods:
- `BreadthFirstSearch(MyGraph<Vertex> graph, Vertex source)`: Constructor to initialize BFS with the given graph and source vertex.
- `bfs(MyGraph<Vertex> graph, Vertex source)`: Performs the BFS starting from the source vertex.

### Usage Examples:
```java
// Creating an instance of MyGraph
MyGraph<String> graph = new MyGraph<>(true);

// Adding vertices and edges
graph.addVertex("Almaty");
graph.addEdge("Almaty", "Astana");

// Performing BFS
Search<String> bfs = new BreadthFirstSearch<>(graph, "Almaty");

// Checking if there is a path to a vertex
boolean hasPath = bfs.hasPathTo("Astana"); // Returns true or false

// Retrieving the path to a vertex
Iterable<String> path = bfs.pathTo("Astana");
```


## DepthFirstSearch

`DepthFirstSearch` - a class implementing the depth-first search algorithm for unweighted graphs. It extends the Search class and uses recursion to explore vertices deeply before backtracking.

### Methods:
- `DepthFirstSearch(MyGraph<Vertex> graph, Vertex source)`: Constructor to initialize DFS with the given graph and source vertex.
- `dfs(MyGraph<Vertex> graph, Vertex v)`: Performs the DFS starting from the source vertex.

### Usage Example:
```java
// Creating an instance of MyGraph
MyGraph<String> graph = new MyGraph<>(true);

// Adding vertices and edges
graph.addVertex("Almaty");
graph.addEdge("Almaty", "Astana");

// Performing DFS
Search<String> dfs = new DepthFirstSearch<>(graph, "Almaty");

// Checking if there is a path to a vertex
boolean hasPath = dfs.hasPathTo("Astana"); // Returns true or false

// Retrieving the path to a vertex
Iterable<String> path = dfs.pathTo("Astana");
```


## DijkstraSearch
`DijkstraSearch` - a class implementing Dijkstra's algorithm for finding the shortest path in weighted graphs. It extends the Search class and uses a priority queue to explore vertices based on their current shortest distance.

### Methods:
- `DijkstraSearch(WeightedGraph<Vertex> graph, Vertex source)`: Constructor to initialize Dijkstra's algorithm with the given graph and source vertex.
- `relax(Vertex v, Vertex w, double weight)`: Relaxes the edge between two vertices, updating their shortest path distance if a shorter path is found.

### Usage Example:
```java
// Creating an instance of WeightedGraph
WeightedGraph<String> weightedGraph = new WeightedGraph<>(true);

// Adding vertices and weighted edges
weightedGraph.addVertex("Almaty");
weightedGraph.addEdge("Almaty", "Astana", 2.1);

// Performing Dijkstra's algorithm
Search<String> dijkstra = new DijkstraSearch<>(weightedGraph, "Almaty");

// Checking if there is a path to a vertex
boolean hasPath = dijkstra.hasPathTo("Astana"); // Returns true or false

// Retrieving the path to a vertex
Iterable<String> path = dijkstra.pathTo("Astana");
```

import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph();
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        g.addEdge(1, 2, false, adjList);
        g.addEdge(1, 3, false, adjList);
        g.addEdge(2, 4, false, adjList);
        g.addEdge(3, 4, false, adjList);
        g.addEdge(3, 5, false, adjList);
        g.addEdge(4, 5, false, adjList);
        g.printAdj(adjList);
    }
}

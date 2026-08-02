import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {
    public void addEdge(int u, int v, boolean dir, HashMap<Integer, List<Integer>> adjList) {
        adjList.putIfAbsent(u, new ArrayList<>());
        if (dir) {
            adjList.get(u).add(v);
        } else {
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
    }

    public void printAdj(HashMap<Integer, List<Integer>> adjList) {
        for (int key : adjList.keySet()) {
            System.out.print(key + " -> ");
            for (int nbr : adjList.get(key)) {
                System.out.print(nbr + ", ");
            }
            System.out.println();
        }
    }
}

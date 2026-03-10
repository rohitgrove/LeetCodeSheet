import java.util.HashMap;
import java.util.List;

public class UndirectedGraphCycleDetectionUsingDFS {
    static HashMap<Integer, List<Integer>> adjList = new HashMap<>();

    public static boolean cycleDetection(int src, HashMap<Integer, Boolean> vis, int parent) {
        vis.put(src, true);

        for (int nbr : adjList.get(src)) {
            if (vis.containsKey(nbr)) {
                if (nbr == parent) {
                    continue;
                }

                if (!vis.containsKey(nbr)) {
                    if (cycleDetection(nbr, vis, parent)) {
                        return true;
                    }
                } else if (vis.containsKey(nbr)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isCylic(int V) {
        HashMap<Integer, Boolean> vis = new HashMap<>();

        for (int i = 0; i < V; i++) {
            if (!vis.containsKey(i)) {
                if (cycleDetection(i, vis, -1)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge(0, 1, false, adjList);
        g.addEdge(1, 2, false, adjList);
        g.addEdge(1, 3, false, adjList);

        g.addEdge(2, 4, false, adjList);
        g.addEdge(2, 5, false, adjList);

        g.addEdge(3, 4, false, adjList);

        int src = 6;
        boolean isCylic = isCylic(src);
        if (isCylic) {
            System.out.println("Cycle Present hai");
        } else {
            System.out.println("Cycle Present nhi hai");
        }
    }
}

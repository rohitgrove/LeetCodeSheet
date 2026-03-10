import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class UndirectedGraphCycleDetectionUsingBFS {
    static HashMap<Integer, List<Integer>> adjList = new HashMap<>();

    public static boolean cycleDetection(int src, HashMap<Integer, Boolean> vis) {
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, Integer> parent = new HashMap<>();

        q.offer(src);
        parent.put(src, -1);

        while (!q.isEmpty()) {
            int currNode = q.poll();

            for (int nbr : adjList.get(currNode)) {
                if (parent.get(currNode) == nbr) {
                    continue;
                }

                if (!vis.containsKey(nbr)) {
                    q.offer(nbr);
                    vis.put(nbr, true);
                    parent.put(nbr, currNode);
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
                if (cycleDetection(i, vis)) {
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

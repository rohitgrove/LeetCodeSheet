import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphPrint {
    public void printAdj(HashMap<Integer, List<Integer>> adjList) {
        for (int key : adjList.keySet()) {
            System.out.print(key + " -> ");
            for (int nbr : adjList.get(key)) {
                System.out.print(nbr + ", ");
            }
            System.out.println();
        }
    }

    private void bfsUtil(int node, HashMap<Integer, Boolean> vis, HashMap<Integer, List<Integer>> adjList) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        vis.put(node, true);

        while (!q.isEmpty()) {
            int frontNode = q.poll();
            System.out.print(frontNode + " ");

            if (!adjList.containsKey(frontNode)) {
                continue;
            }

            for (int nbr : adjList.get(frontNode)) {
                if (!vis.containsKey(nbr)) {
                    q.offer(nbr);
                    vis.put(nbr, true);
                }
            }
        }
    }

    public void bfs(int start, int end, HashMap<Integer, List<Integer>> adjList) {
        HashMap<Integer, Boolean> vis = new HashMap<>();
        for (int node = start; node <= end; node++) {
            if (!vis.containsKey(node)) {
                bfsUtil(node, vis, adjList);
            }
        }
    }

    private void dfsUtil(int node, HashMap<Integer, Boolean> vis, HashMap<Integer, List<Integer>> adjList) {
        System.out.print(node + " ");
        vis.put(node, true);

        if (adjList.containsKey(node)) {
            for (int nbr : adjList.get(node)) {
                if (!vis.containsKey(nbr)) {
                    dfsUtil(nbr, vis, adjList);
                }
            }
        }
    }

    public void dfs(int start, int end, HashMap<Integer, List<Integer>> adjList) {
        HashMap<Integer, Boolean> vis = new HashMap<>();
        for (int node = start; node <= end; node++) {
            if (!vis.containsKey(node)) {
                dfsUtil(node, vis, adjList);
            }
        }
    }
}

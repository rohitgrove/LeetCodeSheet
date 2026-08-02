import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CountTheNumberOfComponents {
    public static void bfs(int node, HashMap<Integer, Boolean> vis, HashMap<Integer, List<Integer>> adjList) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        vis.put(node, true);

        while (!q.isEmpty()) {
            int frontNode = q.poll();

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

    public static int countComponents(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] row : edges) {
            int u = row[0];
            int v = row[1];
            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        int cnt = 0;
        HashMap<Integer, Boolean> vis = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!vis.containsKey(i)) {
                bfs(i, vis, adjList);
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        int edges1[][] = { { 0, 1 },
                { 0, 2 },
                { 1, 2 },
                { 3, 4 } }; // 3
        System.out.println(countComponents(6, edges1));
        int edges2[][] = { { 0, 1 },
                { 0, 2 },
                { 1, 2 },
                { 3, 4 },
                { 3, 5 } }; // 2
        System.out.println(countComponents(6, edges2));

        int edges3[][] = { { 0, 1 },
                { 1, 2 },
                { 3, 3 } }; // 2
        System.out.println(countComponents(4, edges3));
        int edges4[][] = { { 0, 1 },
                { 1, 2 },
                { 2, 3 },
                { 4, 5 },
                { 6, 6 } }; // 3
        System.out.println(countComponents(7, edges4));
    }
}

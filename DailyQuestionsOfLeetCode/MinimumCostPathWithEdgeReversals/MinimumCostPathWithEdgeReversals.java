import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumCostPathWithEdgeReversals {
    public static int dijkstra(int n, HashMap<Integer, List<Edge>> G) {
        int INF = 1_000_000_000;
        int[] dist = new int[n];
        boolean[] vis = new boolean[n];
        Arrays.fill(dist, INF);
        dist[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[] { 0, 0 });

        while (!pq.isEmpty()) {
            int u = pq.poll()[1];

            if (vis[u]) {
                continue;
            }
            vis[u] = true;

            if (G.containsKey(u)) {
                for (Edge e : G.get(u)) {
                    int data = e.data;
                    int wt = e.wt;
                    if (dist[u] + wt < dist[data]) {
                        dist[data] = dist[u] + wt;
                        pq.offer(new int[] { dist[u] + wt, data });
                    }
                }
            }
        }

        return dist[n - 1] == INF ? -1 : dist[n - 1];
    }

    public static int minCost(int n, int[][] edges) {
        HashMap<Integer, List<Edge>> G = new HashMap<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            G.putIfAbsent(u, new ArrayList<>());
            G.putIfAbsent(v, new ArrayList<>());

            G.get(u).add(new Edge(v, w));
            G.get(v).add(new Edge(u, 2 * w));
        }

        return dijkstra(n, G);
    }

    public static void main(String[] args) {
        int edges1[][] = { { 0, 1, 3 },
                { 3, 1, 1 },
                { 2, 3, 4 },
                { 0, 2, 2 } };
        System.out.println(minCost(4, edges1));
        int edges2[][] = { { 0, 2, 1 },
                { 2, 1, 1 },
                { 1, 3, 1 },
                { 2, 3, 3 } };
        System.out.println(minCost(4, edges2));
    }
}

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class PythogoreanDistanceNodesInATreeQ3 {
    private static int[] bfs(int n, List<List<Integer>> adj, int src) {
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(src);
        dist[src] = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj.get(u)) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    q.offer(v);
                }
            }
        }
        return dist;
    }

    public static int specialNodes(int n, int[][] edges, int x, int y, int z) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int[] dx = bfs(n, adj, x);
        int[] dy = bfs(n, adj, y);
        int[] dz = bfs(n, adj, z);

        int count = 0;

        for (int i = 0; i < n; i++) {
            int a = dx[i], b = dy[i], c = dz[i];
            int[] arr = { a, b, c };
            Arrays.sort(arr);
            long A = arr[0], B = arr[1], C = arr[2];
            if (A * A + B * B == C * C) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int edges1[][] = { { 0, 1 },
                { 0, 2 },
                { 0, 3 } };
        System.out.println(specialNodes(4, edges1, 1, 2, 3));
        int edges2[][] = { { 0, 1 },
                { 1, 2 },
                { 2, 3 } };
        System.out.println(specialNodes(4, edges2, 0, 3, 2));
        int edges3[][] = { { 0, 1 },
                { 1, 2 },
                { 1, 3 } };
        System.out.println(specialNodes(4, edges3, 1, 3, 0));
    }
}

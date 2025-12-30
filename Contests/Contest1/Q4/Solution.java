import java.util.*;

public class Solution {
    public static int shortestPath(int n, int[][] edges, int start, int end) {
        // Edge case
        if (start == end) {
            return 0;
        }

        // Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u); // undirected
        }

        // Distance array
        int[] dist = new int[n];
        Arrays.fill(dist, -1);

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : adj.get(node)) {
                if (dist[neighbor] == -1) { // not visited
                    dist[neighbor] = dist[node] + 1;
                    queue.offer(neighbor);

                    if (neighbor == end) {
                        return dist[neighbor];
                    }
                }
            }
        }

        return -1; // end not reachable
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {
                { 0, 1 }, { 0, 2 }, { 1, 3 }, { 2, 3 }, { 3, 4 }, { 4, 5 }
        };
        int start = 0;
        int end = 5;

        System.out.println(shortestPath(n, edges, start, end)); // Output: 4
    }
}
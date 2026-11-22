import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class EarliestSignalActivationTimes {
    public static long[] earliestActivationTimes(int n, int[][] edges, int[] requiredSignals) {
        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int delay = edge[2];

            graph[u].add(new int[] { v, delay });
        }

        long[] ans = new long[n];
        Arrays.fill(ans, -1);

        int[] received = new int[n];

        PriorityQueue<long[]> pq = new PriorityQueue<>(
                (a, b) -> Long.compare(a[0], b[0]));

        ans[0] = 0;

        for (int[] edge : graph[0]) {
            pq.offer(new long[] { edge[1], edge[0] });
        }

        while (!pq.isEmpty()) {
            long[] current = pq.poll();
            long time = current[0];
            int node = (int) current[1];

            if (ans[node] != -1) {
                continue;
            }
            received[node]++;
            if (received[node] >= requiredSignals[node]) {
                ans[node] = time;
                for (int[] edge : graph[node]) {
                    int nextNode = edge[0];
                    int delay = edge[1];

                    pq.offer(new long[] {
                            time + delay,
                            nextNode
                    });
                }
            }
        }

        return ans;
    }

    public static void printArr(long arr[]) {
        for (long ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n1 = 3;
        int[][] edges1 = { { 0, 1, 1 }, { 0, 2, 1 } };
        int[] requiredSignals1 = { 1, 1, 2 };
        printArr(earliestActivationTimes(n1, edges1, requiredSignals1));
        int n2 = 4;
        int[][] edges2 = { { 0, 1, 1 }, { 0, 2, 1 }, { 1, 3, 2 }, { 2, 3, 2 } };
        int[] requiredSignals2 = { 3, 1, 1, 2 };
        printArr(earliestActivationTimes(n2, edges2, requiredSignals2));
        int n3 = 4;
        int[][] edges3 = { { 0, 1, 2 }, { 1, 2, 3 }, { 0, 2, 5 }, { 2, 3, 1 } };
        int[] requiredSignals3 = { 3, 1, 2, 1 };
        printArr(earliestActivationTimes(n3, edges3, requiredSignals3));
        int n4 = 4;
        int[][] edges4 = new int[][] { { 0, 1, 2 }, { 1, 0, 1 }, { 1, 2, 1 }, { 2, 3, 1 }, { 3, 2, 1 } };
        int[] requiredSignals4 = new int[] { 3, 1, 2, 1 };
        printArr(earliestActivationTimes(n4, edges4, requiredSignals4));
    }
}

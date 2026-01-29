import java.util.Arrays;

public class MinimumCostToConvertString1 {
    public static long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int ALPHABET = 26;
        long INF = Long.MAX_VALUE / 4;

        // 1 distance matrix
        long[][] dist = new long[ALPHABET][ALPHABET];

        // initialize
        for (int i = 0; i < ALPHABET; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        // 2 build graph (take minimum cost if duplicate edges exist)
        for (int i = 0; i < original.length; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }

        // 3 Floyd-Warshall (all-pairs shortest path)
        // imdt = Intermediate, src = source, dest = destination
        for (int imdt = 0; imdt < ALPHABET; imdt++) {
            for (int src = 0; src < ALPHABET; src++) {
                for (int dest = 0; dest < ALPHABET; dest++) {
                    if (dist[src][imdt] + dist[imdt][dest] < dist[src][dest]) {
                        dist[src][dest] = dist[src][imdt] + dist[imdt][dest];
                    }
                }
            }
        }

        // 4 compute total cost
        long totalCost = 0;

        for (int i = 0; i < source.length(); i++) {
            int s = source.charAt(i) - 'a';
            int t = target.charAt(i) - 'a';

            if (dist[s][t] == INF) {
                return -1;
            }
            totalCost += dist[s][t];
        }

        return totalCost;
    }


    public static void main(String[] args) {
        String source1 = "abcd", target1 = "acbe";
        char original1[] = { 'a', 'b', 'c', 'c', 'e', 'd' }, changed1[] = { 'b', 'c', 'b', 'e', 'b', 'e' };
        int cost1[] = { 2, 5, 5, 1, 2, 20 };
        System.out.println(minimumCost(source1, target1, original1, changed1, cost1));
        String source2 = "aaaa", target2 = "bbbb";
        char original2[] = { 'a', 'c' }, changed2[] = { 'c', 'b' };
        int cost2[] = { 1, 2 };
        System.out.println(minimumCost(source2, target2, original2, changed2, cost2));
        String source3 = "abcd", target3 = "abce";
        char original3[] = { 'a' }, changed3[] = { 'e' };
        int cost3[] = { 10000 };
        System.out.println(minimumCost(source3, target3, original3, changed3, cost3));
    }
}

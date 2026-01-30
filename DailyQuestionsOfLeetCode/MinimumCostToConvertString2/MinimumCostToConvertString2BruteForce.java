import java.util.Arrays;
import java.util.HashMap;

public class MinimumCostToConvertString2BruteForce {
    public static long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        long INF = (long) 1e18;
        int n = source.length();

        // 1) Build graph: original -> changed
        HashMap<String, Integer> id = new HashMap<>();
        int idx = 0;

        for (String s : original) {
            if (!id.containsKey(s))
                id.put(s, idx++);
        }
        for (String s : changed) {
            if (!id.containsKey(s))
                id.put(s, idx++);
        }

        int m = id.size();
        long[][] dist = new long[m][m];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < original.length; i++) {
            int u = id.get(original[i]);
            int v = id.get(changed[i]);
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }

        // 2) Floyd-Warshall (multi-step allowed)
        for (int k = 0; k < m; k++) {
            for (int i = 0; i < m; i++) {
                if (dist[i][k] == INF)
                    continue;
                for (int j = 0; j < m; j++) {
                    if (dist[k][j] == INF)
                        continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        // 3) DP
        // dp[i] = min cost to convert [0..i-1]
        long[] dp = new long[n + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i] == INF) {
                continue;
            }

            // Case 1: characters already equal
            if (source.charAt(i) == target.charAt(i)) {
                dp[i + 1] = Math.min(dp[i + 1], dp[i]);
            }

            // Case 2: try all substrings starting at i
            for (int j = i; j < n; j++) {
                String s1 = source.substring(i, j + 1);
                String s2 = target.substring(i, j + 1);

                if (!id.containsKey(s1) || !id.containsKey(s2))
                    continue;

                long c = dist[id.get(s1)][id.get(s2)];
                if (c == INF)
                    continue;

                dp[j + 1] = Math.min(dp[j + 1], dp[i] + c);
            }
        }

        return dp[n] == INF ? -1 : dp[n];
    }

    public static void main(String[] args) {
        String source1 = "abcd", target1 = "acbe", original1[] = { "a", "b", "c", "c", "e", "d" },
                changed1[] = { "b", "c", "b", "e", "b", "e" };
        int cost1[] = { 2, 5, 5, 1, 2, 20 };
        System.out.println(minimumCost(source1, target1, original1, changed1, cost1));
        String source2 = "abcdefgh", target2 = "acdeeghh", original2[] = { "bcd", "fgh", "thh" },
                changed2[] = { "cde", "thh", "ghh" };
        int cost2[] = { 1, 3, 5 };
        System.out.println(minimumCost(source2, target2, original2, changed2, cost2));
        String source3 = "abcdefgh", target3 = "addddddd", original3[] = { "bcd", "defgh" },
                changed3[] = { "ddd", "ddddd" };
        int cost3[] = { 100, 1578 };
        System.out.println(minimumCost(source3, target3, original3, changed3, cost3));
    }
}

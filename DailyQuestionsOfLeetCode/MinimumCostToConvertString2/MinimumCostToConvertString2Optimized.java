import java.util.Arrays;
import java.util.HashMap;

public class MinimumCostToConvertString2Optimized {
    public static void insert(TrieNode root, String s, int id) {
        TrieNode node = root;
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            if (node.next[idx] == null) {
                node.next[idx] = new TrieNode();
            }
            node = node.next[idx];
        }
        node.id = id;
    }

    public static long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        int n = source.length();
        HashMap<String, Integer> strToId = new HashMap<>();
        TrieNode root = new TrieNode();
        int idCounter = 0;

        for (String s : original) {
            if (!strToId.containsKey(s)) {
                strToId.put(s, idCounter);
                insert(root, s, idCounter);
                idCounter++;
            }
        }
        for (String s : changed) {
            if (!strToId.containsKey(s)) {
                strToId.put(s, idCounter);
                insert(root, s, idCounter);
                idCounter++;
            }
        }

        long[][] dist = new long[idCounter][idCounter];
        long INF = Long.MAX_VALUE;
        for (long[] row : dist) Arrays.fill(row, INF);
        for (int i = 0; i < idCounter; i++) dist[i][i] = 0;

        for (int i = 0; i < original.length; i++) {
            int u = strToId.get(original[i]);
            int v = strToId.get(changed[i]);
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }

        for (int k = 0; k < idCounter; k++) {
            for (int i = 0; i < idCounter; i++) {
                if (dist[i][k] == INF) continue;
                for (int j = 0; j < idCounter; j++) {
                    if (dist[k][j] == INF) continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        long[] dp = new long[n + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        char[] s = source.toCharArray();
        char[] t = target.toCharArray();

        for (int i = 0; i < n; i++) {
            if (dp[i] == INF) continue;

            if (s[i] == t[i]) {
                dp[i + 1] = Math.min(dp[i + 1], dp[i]);
            }

            TrieNode tNode = root;
            HashMap<Integer, Integer> lenToTargetId = new HashMap<>();
            
            for (int j = i; j < n; j++) {
                int idx = t[j] - 'a';
                if (tNode.next[idx] == null) break;
                tNode = tNode.next[idx];
                if (tNode.id != -1) {
                    lenToTargetId.put(j - i + 1, tNode.id);
                }
            }

            TrieNode sNode = root;
            for (int j = i; j < n; j++) {
                int idx = s[j] - 'a';
                if (sNode.next[idx] == null) break;
                sNode = sNode.next[idx];
                if (sNode.id != -1) {
                    int len = j - i + 1;
                    if (lenToTargetId.containsKey(len)) {
                        int sId = sNode.id;
                        int tId = lenToTargetId.get(len);
                        if (dist[sId][tId] != INF) {
                            dp[i + len] = Math.min(dp[i + len], dp[i] + dist[sId][tId]);
                        }
                    }
                }
            }
        }
        return (dp[n] == INF) ? -1 : dp[n];
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

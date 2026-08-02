import java.util.HashMap;

public class CountTheNumberOfComponents {
    public static void dfs(int src, HashMap<Integer, Boolean> vis, int n, int[][] isConnected) {
        vis.put(src, true);

        for (int nbr = 0; nbr < isConnected[0].length; nbr++) {
            if (isConnected[src][nbr] == 1) {
                if (!vis.containsKey(nbr)) {
                    dfs(nbr, vis, n, isConnected);
                }
            }
        }
    }

    public static int findCircleNum(int[][] isConnected) {
        HashMap<Integer, Boolean> vis = new HashMap<>();
        int n = isConnected.length;

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (!vis.containsKey(i)) {
                dfs(i, vis, n, isConnected);
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        int isConnected1[][] = { { 1, 1, 0 },
                { 1, 1, 0 },
                { 0, 0, 1 } };
        System.out.println(findCircleNum(isConnected1));
        int isConnected2[][] = { { 1, 0, 0 },
                { 1, 0, 0 },
                { 0, 0, 1 } };
        System.out.println(findCircleNum(isConnected2));
    }
}

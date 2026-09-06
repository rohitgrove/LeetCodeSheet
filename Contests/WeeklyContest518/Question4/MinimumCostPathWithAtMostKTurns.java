import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumCostPathWithAtMostKTurns {
    public static boolean isOutOfBound(int nr, int m, int nc, int n) {
        return nr < 0 || nr >= m || nc < 0 || nc >= n;
    }

    public static int minCost(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        int[][][][] dist = new int[m][n][k + 1][4];
        for (int[][][] a : dist) {
            for (int[][] b : a) {
                for (int[] c : b) {
                    Arrays.fill(c, Integer.MAX_VALUE);
                }
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int d = 0; d < 4; d++) {
            dist[0][0][0][d] = grid[0][0];
            pq.offer(new int[] { grid[0][0], 0, 0, 0, d });
        }

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cost = cur[0], r = cur[1], c = cur[2], turns = cur[3], lastDir = cur[4];

            if (r == m - 1 && c == n - 1) {
                return cost;
            }
            if (cost > dist[r][c][turns][lastDir]) {
                continue;
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + dirs[d][0];
                int nc = c + dirs[d][1];
                if (isOutOfBound(nr, m, nc, n)) {
                    continue;
                }

                int newTurns = turns + (d != lastDir ? 1 : 0);
                if (newTurns > k)
                    continue;

                int newCost = cost + grid[nr][nc];
                if (newCost < dist[nr][nc][newTurns][d]) {
                    dist[nr][nc][newTurns][d] = newCost;
                    pq.offer(new int[] { newCost, nr, nc, newTurns, d });
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] grid1 = {
                { 2, 7, 3 },
                { 1, 4, 5 }
        };

        System.out.println(minCost(grid1, 1));
        // Expected: 12

        int[][] grid2 = {
                { 4, 1, 9 },
                { 3, 2, 5 },
                { 4, 8, 6 }
        };

        System.out.println(minCost(grid2, 2));
        // Expected: 20

        int[][] grid3 = {
                { 1, 9 },
                { 3, 4 }
        };

        System.out.println(minCost(grid3, 0));
        // Expected: -1

        int[][] grid4 = {
                { 9 }
        };

        System.out.println(minCost(grid4, 5));
        // Expected: 9
    }
}
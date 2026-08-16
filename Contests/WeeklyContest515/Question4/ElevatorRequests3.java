public class ElevatorRequests3 {
    public static long elevatorRequests(int n, int start, int[][] requests) {
        int m = requests.length;
        int total = 1 << m;
        long[][] dp = new long[total][m];

        long INF = Long.MAX_VALUE / 4;

        for (int mask = 0; mask < total; mask++) {
            for (int i = 0; i < m; i++) {
                dp[mask][i] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            long dist = Math.abs((long) start - requests[i][1]);
            long time = Math.max(dist, (long) requests[i][0]);
            dp[1 << i][i] = time;
        }

        for (int mask = 1; mask < total; mask++) {
            for (int last = 0; last < m; last++) {
                if ((mask & (1 << last)) == 0) {
                    continue;
                }

                if (dp[mask][last] == INF) {
                    continue;
                }

                for (int next = 0; next < m; next++) {
                    if ((mask & (1 << next)) != 0) {
                        continue;
                    }

                    long distance = Math.abs(
                            (long) requests[last][1] - requests[next][1]);

                    long time = dp[mask][last] + distance;
                    time = Math.max(time, (long) requests[next][0]);
                    int newMask = mask | (1 << next);
                    dp[newMask][next] = Math.min(dp[newMask][next], time);
                }
            }
        }

        int fullMask = total - 1;
        long ans = INF;

        for (int last = 0; last < m; last++) {
            ans = Math.min(ans, dp[fullMask][last]);
        }

        return ans;
    }

    public static void main(String[] args) {
        int requests1[][] = { { 0, 8 },
                { 6, 5 } };
        System.out.println(elevatorRequests(9, 0, requests1));
        int requests2[][] = { { 1, 7 },
                { 7, 3 } };
        System.out.println(elevatorRequests(8, 5, requests2));
        int requests3[][] = { { 0, 5 },
                { 0, 1 },
                { 6, 3 } };
        System.out.println(elevatorRequests(7, 3, requests3));
    }
}

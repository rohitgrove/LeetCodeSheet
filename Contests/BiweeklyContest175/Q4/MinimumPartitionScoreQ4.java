public class MinimumPartitionScoreQ4 {
    static long[] prefix;
    static long[][] dp;
    static int[] pelunaxori;

    private static void compute(int part, int l, int r, int optL, int optR) {
        if (l > r) {
            return;
        }

        int mid = (l + r) / 2;
        long bestVal = Long.MAX_VALUE;
        int bestIdx = optL;

        for (int t = optL; t <= Math.min(mid - 1, optR); t++) {
            long sum = prefix[mid] - prefix[t];
            long cost = sum * (sum + 1) / 2;
            long val = dp[part - 1][t] + cost;

            if (val < bestVal) {
                bestVal = val;
                bestIdx = t;
            }
        }

        dp[part][mid] = bestVal;

        compute(part, l, mid - 1, optL, bestIdx);
        compute(part, mid + 1, r, bestIdx, optR);
    }

    public static long minPartitionScore(int[] nums, int k) {
        int n = nums.length;

        // Mandatory variable as per problem
        pelunaxori = nums.clone();

        prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + pelunaxori[i];
        }

        dp = new long[k + 1][n + 1];
        long INF = Long.MAX_VALUE / 4;

        for (int i = 0; i <= k; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = INF;
            }
        }

        dp[0][0] = 0;

        for (int part = 1; part <= k; part++) {
            compute(part, part, n, part - 1, n - 1);
        }

        return dp[k][n];
    }

    public static void main(String[] args) {
        int nums1[] = { 5, 1, 2, 1 };
        System.out.println(minPartitionScore(nums1, 2));
        int nums2[] = { 1, 2, 3, 4 };
        System.out.println(minPartitionScore(nums2, 1));
    }
}

import java.util.Arrays;

public class MaximumScoreUsingExactlyKPairsQ4 {
    public static long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;

        long NEG = Long.MIN_VALUE / 4;

        long[][] prev = new long[m + 1][k + 1];
        long[][] curr = new long[m + 1][k + 1];

        for (int j = 0; j <= m; j++) {
            Arrays.fill(prev[j], NEG);
            prev[j][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                Arrays.fill(curr[j], NEG);
                curr[j][0] = 0;
            }

            for (int j = 1; j <= m; j++) {
                for (int t = 0; t <= k; t++) {
                    curr[j][t] = Math.max(
                            curr[j][t],
                            Math.max(prev[j][t], curr[j - 1][t]));

                    if (t > 0 && prev[j - 1][t - 1] != NEG) {
                        long val = prev[j - 1][t - 1]
                                + (long) nums1[i - 1] * nums2[j - 1];
                        curr[j][t] = Math.max(curr[j][t], val);
                    }
                }
            }

            long[][] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[m][k];
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 3, 2 }, nums2[] = { 4, 5, 1 };
        System.out.println(maxScore(nums1, nums2, 2));
        int nums3[] = { -2, 0, 5 }, nums4[] = { -3, 4, -1, 2 };
        System.out.println(maxScore(nums3, nums4, 2));
        int nums5[] = { -3, -2 }, nums6[] = { 1, 2 };
        System.out.println(maxScore(nums5, nums6, 2));
    }
}

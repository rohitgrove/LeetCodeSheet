import java.util.Arrays;

public class LongestSubaarayDivisibleByKWithAtMostOneNegation2 {
    public static int longestSubarray(int[] nums, int k) {
        int n = nums.length;

        int[] prefix = new int[n + 1];
        int[] first = new int[k];
        Arrays.fill(first, -1);
        first[0] = 0;

        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum = (int) (((long) sum + nums[i - 1]) % k);
            if (sum < 0) {
                sum += k;
            }

            prefix[i] = sum;

            if (first[sum] == -1) {
                first[sum] = i;
            }
        }

        Integer[] order = new Integer[k];
        int count = 0;

        for (int i = 0; i < k; i++) {
            if (first[i] != -1) {
                order[count++] = i;
            }
        }

        Arrays.sort(order, 0, count, (a, b) -> Integer.compare(first[a], first[b]));

        int[] pointer = new int[k];
        int[] best = new int[k];
        Arrays.fill(best, Integer.MAX_VALUE);

        for (int i = 0; i < k; i++) {
            if (first[i] != -1) {
                best[i] = first[i];
            }
        }

        int ans = 0;

        for (int r = 1; r <= n; r++) {
            int x = nums[r - 1] % k;
            if (x < 0) {
                x += k;
            }

            while (pointer[x] < count && first[order[pointer[x]]] < r) {
                int q = order[pointer[x]];
                int target = (int) (((long) q + 2L * x) % k);

                best[target] = Math.min(best[target], first[q]);
                pointer[x]++;
            }

            int current = prefix[r];

            if (best[current] != Integer.MAX_VALUE) {
                ans = Math.max(ans, r - best[current]);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = { 4, 1, 2 };
        int k1 = 3;

        int[] nums2 = { 5, 3, 4 };
        int k2 = 7;

        int[] nums3 = { 2, 2, 5 };
        int k3 = 6;

        System.out.println(longestSubarray(nums1, k1));
        System.out.println(longestSubarray(nums2, k2));
        System.out.println(longestSubarray(nums3, k3));
    }
}
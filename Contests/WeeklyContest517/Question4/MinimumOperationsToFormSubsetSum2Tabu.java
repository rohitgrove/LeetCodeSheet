import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MinimumOperationsToFormSubsetSum2Tabu {
    public static int minOperations(int[] nums, int sum) {
        int INF = 1000000000;
        int[] dp = new int[sum + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int num : nums) {
            List<int[]> options = getOptions(num, sum);

            int[] next = dp.clone();

            for (int[] op : options) {
                int value = op[0];
                int cost = op[1];

                for (int s = 0; s + value <= sum; s++) {
                    if (dp[s] != INF) {
                        next[s + value] = Math.min(
                                next[s + value],
                                dp[s] + cost);
                    }
                }
            }

            dp = next;
        }

        return dp[sum] == INF ? -1 : dp[sum];
    }

    public static List<int[]> getOptions(int num, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int x = num;
        int divCost = 0;

        while (x > 0) {
            int y = x;
            int mulCost = 0;

            while (y <= sum) {
                int cost = divCost + mulCost;

                if (!map.containsKey(y) || cost < map.get(y)) {
                    map.put(y, cost);
                }

                if (y > sum / 2) {
                    break;
                }

                y *= 2;
                mulCost++;
            }

            x /= 2;
            divCost++;
        }

        List<int[]> result = new ArrayList<>();

        for (int key : map.keySet()) {
            result.add(new int[] { key, map.get(key) });
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = { 10, 2 };
        System.out.println(minOperations(nums1, 13));
        // System.out.println(minOperationsTabu(nums1, 13));

        int[] nums2 = { 6, 3 };
        System.out.println(minOperations(nums2, 8));
        // System.out.println(minOperationsTabu(nums2, 8));

        int[] nums3 = { 2, 2 };
        System.out.println(minOperations(nums3, 7));
        // System.out.println(minOperationsTabu(nums3, 7));
    }
}

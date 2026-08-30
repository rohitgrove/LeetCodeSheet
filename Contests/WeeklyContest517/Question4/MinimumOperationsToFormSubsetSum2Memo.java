import java.util.Arrays;
import java.util.HashMap;

public class MinimumOperationsToFormSubsetSum2Memo {
    public int solve(int[] nums, int index, int target, int dp[][], int INF, int sum) {
        if (target == 0) {
            return 0;
        }

        if (index == nums.length) {
            return INF;
        }

        if (dp[index][target] != -1) {
            return dp[index][target];
        }

        int ans = solve(nums, index + 1, target, dp, INF, sum);

        HashMap<Integer, Integer> options = getOptions(nums[index], sum);

        for (int key : options.keySet()) {
            int value = key;
            int cost = options.get(key);

            if (value <= target) {
                int next = solve(nums, index + 1, target - value, dp, INF, sum);

                if (next != INF) {
                    ans = Math.min(ans, cost + next);
                }
            }
        }

        return dp[index][target] = ans;
    }

    public HashMap<Integer, Integer> getOptions(int x, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int value = x;
        int divideCost = 0;

        while (value > 0) {
            int current = value;
            int multiplyCost = 0;

            while (current <= sum) {
                if (!map.containsKey(current) ||
                        divideCost + multiplyCost < map.get(current)) {
                    map.put(current, divideCost + multiplyCost);
                }

                if (current > sum / 2) {
                    break;
                }

                current *= 2;
                multiplyCost++;
            }

            value /= 2;
            divideCost++;
        }

        return map;
    }
    public int minOperations(int[] nums, int sum) {
        int[][] dp = new int[nums.length][sum + 1];
        int INF = 1000000000;
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ans = solve(nums, 0, sum, dp, INF, sum);

        return ans >= INF ? -1 : ans;
    }
}

import java.util.*;

public class MaximumTotalDamageWithSpellCasting {
    public static long solveUsingRec(int idx, int[] power) {
        if (idx >= power.length) {
            return 0;
        }

        long currentPower = power[idx];

        int groupEndIndex = idx;
        while (groupEndIndex < power.length && power[groupEndIndex] == currentPower) {
            groupEndIndex++;
        }

        int count = groupEndIndex - idx;
        long notTake = solveUsingRec(groupEndIndex, power);

        long take = currentPower * count;
        int nextValidIndex = groupEndIndex;
        while (nextValidIndex < power.length && power[nextValidIndex] <= currentPower + 2) {
            nextValidIndex++;
        }
        take += solveUsingRec(nextValidIndex, power);

        return Math.max(take, notTake);
    }

    public static long solveUsingMemo(int idx, int[] power, long[] dp) {
        if (idx >= power.length) {
            return 0;
        }

        if (dp[idx] != -1) {
            return dp[idx];
        }

        long currentPower = power[idx];

        int groupEndIndex = idx;
        while (groupEndIndex < power.length && power[groupEndIndex] == currentPower) {
            groupEndIndex++;
        }

        int count = groupEndIndex - idx;
        long notTake = solveUsingMemo(groupEndIndex, power, dp);

        long take = currentPower * count;
        int nextValidIndex = groupEndIndex;
        while (nextValidIndex < power.length && power[nextValidIndex] <= currentPower + 2) {
            nextValidIndex++;
        }
        take += solveUsingMemo(nextValidIndex, power, dp);

        return dp[idx] = Math.max(take, notTake);
    }

    public static long solveUsingTabu(int[] power) {
        long[] dp = new long[power.length + 1];

        for (int idx = power.length - 1; idx >= 0; idx--) {
            long currentPower = power[idx];

            int groupEndIndex = idx;
            while (groupEndIndex < power.length && power[groupEndIndex] == currentPower) {
                groupEndIndex++;
            }

            int count = groupEndIndex - idx;
            long notTake = dp[groupEndIndex];

            long take = currentPower * count;
            int nextValidIndex = groupEndIndex;
            while (nextValidIndex < power.length && power[nextValidIndex] <= currentPower + 2) {
                nextValidIndex++;
            }
            take += dp[nextValidIndex];
            dp[idx] = Math.max(take, notTake);
        }

        return dp[0];
    }

    public static long maximumTotalDamage(int[] power) {
        Arrays.sort(power);

        // return solveUsingRec(0, power);
        // long[] dp = new long[power.length];
        // Arrays.fill(dp, -1);
        // return solveUsingMemo(0, power, dp);

        return solveUsingTabu(power);
    }

    public static void main(String[] args) {
        int power1[] = { 1, 1, 3, 4 };
        System.out.println(maximumTotalDamage(power1));
        int power2[] = { 7, 1, 6, 6 };
        System.out.println(maximumTotalDamage(power2));
    }
}
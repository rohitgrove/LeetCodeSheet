import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountFancyNumbersInARange {
    private static boolean[] goodSum = new boolean[136];
    private static  List<Long> extraGoodNums = new ArrayList<>();

    public static long countFancy(long l, long r) {
        // Step 1: Precompute which sums (up to 135) are "good"
        for (int i = 0; i <= 135; i++) {
            goodSum[i] = isGoodStr(String.valueOf(i));
        }

        // Step 2: Generate all "good" numbers and filter out those with a "good sum"
        Set<Long> goodNums = new HashSet<>();
        for (int i = 1; i <= 9; i++) {
            genInc(i, i, goodNums);
            genDec(i, i, goodNums);
        }
        
        for (long val : goodNums) {
            int sum = getDigitSum(val);
            if (!goodSum[sum]) {
                extraGoodNums.add(val); // Only keep ones not counted by the DP
            }
        }

        // Step 3: Prefix difference
        return solve(r) - solve(l - 1);
    }

    // Helper to evaluate if a string forms a strictly monotone sequence
    private static boolean isGoodStr(String s) {
        if (s.length() == 1) return true;
        
        boolean inc = true;
        boolean dec = true;
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) <= s.charAt(i - 1)) inc = false;
            if (s.charAt(i) >= s.charAt(i - 1)) dec = false;
        }
        
        return inc || dec;
    }

    // Generate strictly increasing numbers
    private static void genInc(long val, int lastDigit, Set<Long> set) {
        set.add(val);
        for (int d = lastDigit + 1; d <= 9; d++) {
            genInc(val * 10 + d, d, set);
        }
    }

    // Generate strictly decreasing numbers
    private static void genDec(long val, int lastDigit, Set<Long> set) {
        set.add(val);
        for (int d = lastDigit - 1; d >= 0; d--) {
            genDec(val * 10 + d, d, set);
        }
    }

    // Calculates the digit sum of a number
    private static int getDigitSum(long val) {
        int sum = 0;
        while (val > 0) {
            sum += val % 10;
            val /= 10;
        }
        return sum;
    }

    // Solves the total valid numbers in range [1, limit]
    private static long solve(long limit) {
        if (limit == 0) return 0;
        
        String S = String.valueOf(limit);
        long[][] memo = new long[S.length()][136];
        for (long[] row : memo) Arrays.fill(row, -1);
        
        // Count numbers using Digit DP
        long ans = digitDP(0, 0, true, S, memo);
        
        // 0 inherently has a sum of 0 (which is single-digit and therefore "good").
        // Since the prompt constraints dictate L >= 1, we exclude 0.
        if (goodSum[0]) ans--; 

        // Add the extra "good" numbers that the DP missed because their sums weren't good
        for (long val : extraGoodNums) {
            if (val <= limit) {
                ans++;
            }
        }
        
        return ans;
    }

    // Digit DP to find count of numbers <= limit with a "good" digit sum
    private static long digitDP(int idx, int sum, boolean isLimit, String S, long[][] memo) {
        if (idx == S.length()) {
            return goodSum[sum] ? 1 : 0;
        }
        if (!isLimit && memo[idx][sum] != -1) {
            return memo[idx][sum];
        }

        long res = 0;
        int maxDigit = isLimit ? (S.charAt(idx) - '0') : 9;
        
        for (int d = 0; d <= maxDigit; d++) {
            res += digitDP(idx + 1, sum + d, isLimit && (d == maxDigit), S, memo);
        }

        if (!isLimit) {
            memo[idx][sum] = res;
        }
        
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countFancy(8, 10));
        System.out.println(countFancy(12340, 12341));
        System.out.println(countFancy(123456788, 123456788));
    }
}
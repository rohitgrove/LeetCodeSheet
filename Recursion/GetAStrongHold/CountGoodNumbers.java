public class CountGoodNumbers {
    static int MOD = 1_000_000_007;

    public static int countGoodNumbersHelperREC(int index, long n) {
        if (n == index) {
            return 1;
        }

        int result = 0;

        if (index % 2 == 0) {
            int evenDigits[] = { 0, 2, 4, 6, 8 };
            for (int digit : evenDigits) {
                result = (result + countGoodNumbersHelperREC(index + 1, n)) & MOD;
            }
        } else {
            int[] primeDigits = { 2, 3, 5, 7 };
            for (int digit : primeDigits) {
                result = (result + countGoodNumbersHelperREC(index + 1, n)) % MOD;
            }
        }

        return result;
    }

    static Long[] dp;

    public static long countGoodNumbersHelperMemo(int index, long n) {
        if (index == n) {
            return 1;
        }

        if (dp[index] != null) {
            return dp[index];
        }

        long result = 0;

        if (index % 2 == 0) {
            int evenDigits[] = { 0, 2, 4, 6, 8 };
            for (int digit : evenDigits) {
                result = (result + countGoodNumbersHelperMemo(index + 1, n)) % MOD;
            }
        } else {
            int[] primeDigits = { 2, 3, 5, 7 };
            for (int digit : primeDigits) {
                result = (result + countGoodNumbersHelperMemo(index + 1, n)) % MOD;
            }
        }

        return dp[index] = result;
    }

    public static long pow(long a, long b) {
        if (b == 0) return 1;

        long half = pow(a, b / 2);

        long result = (half * half) % MOD;

        if (b % 2 == 1) {
            result = (result * a) % MOD;
        }

        return result;
    }

    public static int countGoodNumbers(long n) {
        // return countGoodNumbersHelperREC(0, n);
        // dp = new Long[(int) n + 1];

        // return (int) countGoodNumbersHelperMemo(0, n);
        long even = (n + 1) / 2;
        long odd = n / 2;

        long ans = (pow(5, even) * pow(4, odd)) % MOD;

        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(countGoodNumbers(1));
        System.out.println(countGoodNumbers(4));
        System.out.println(countGoodNumbers(50));
    }
}

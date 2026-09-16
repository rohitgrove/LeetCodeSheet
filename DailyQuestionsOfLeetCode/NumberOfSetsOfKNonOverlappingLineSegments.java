public class NumberOfSetsOfKNonOverlappingLineSegments {
    public static final long MOD = 1_000_000_007L;

    public static long modPow(long base, long exp) {
        long result = 1;

        while (exp > 0) {
            if ((exp & 1L) != 0) {
                result = result * base % MOD;
            }

            base = base * base % MOD;

            exp >>= 1;
        }

        return result;
    }

    public static int numberOfSets(int n, int k) {
        long N = n + k - 1L;
        long R = 2L * k;

        R = Math.min(R, N - R);

        long numerator = 1;
        long denominator = 1;

        for (long i = 1; i <= R; i++) {
            numerator = numerator * (N - R + i) % MOD;

            denominator = denominator * i % MOD;
        }

        long inverseDenominator = modPow(denominator, MOD - 2);

        return (int) (numerator * inverseDenominator % MOD);
    }

    public static void main(String[] args) {
        System.out.println(numberOfSets(4, 2));
        System.out.println(numberOfSets(3, 1));
        System.out.println(numberOfSets(30, 7));
    }
}
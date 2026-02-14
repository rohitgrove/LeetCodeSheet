public class FindNthSmallestIntegerWithKOneBitsQ4 {
    static long[][] nCr = new long[55][55];

    public static long nthSmallest(long n, int k) {
        buildNCR();

        long ans = 0;
        int remainingOnes = k;

        for (int bit = 50; bit >= 0; bit--) {
            if (remainingOnes == 0)
                break;

            long countWithZero = (bit >= remainingOnes) ? nCr[bit][remainingOnes] : 0;

            if (n > countWithZero) {
                ans |= (1L << bit);
                n -= countWithZero;
                remainingOnes--;
            }
        }

        return ans;
    }

    public static void buildNCR() {
        for (int i = 0; i <= 50; i++) {
            nCr[i][0] = nCr[i][i] = 1;
            for (int j = 1; j < i; j++) {
                nCr[i][j] = nCr[i - 1][j - 1] + nCr[i - 1][j];
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(nthSmallest(4, 2));
        System.out.println(nthSmallest(3, 1));
    }
}

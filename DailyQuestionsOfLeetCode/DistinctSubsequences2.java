public class DistinctSubsequences2 {
    public static int distinctSubseqII(String s) {
        final long MOD = 1000000007L;

        long dp = 1;
        long[] last = new long[26];

        for (int i = 0; i < s.length();i++) {
            int ch = s.charAt(i);
            int index = ch - 'a';

            long oldDp = dp;

            dp = (2 * dp - last[index] + MOD) % MOD;

            last[index] = oldDp;
        }

        return (int) ((dp - 1 + MOD) % MOD);
    }

    public static void main(String[] args) {
        System.out.println(distinctSubseqII("abc"));
        System.out.println(distinctSubseqII("aba"));
        System.out.println(distinctSubseqII("aaa"));
    }
}

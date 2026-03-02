public class LongestPalindormicSubsequence {
    public static int solveUsingTabuSO1(String text1, String text2) {
        int next[] = new int[text1.length() + 1];
        int curr[] = new int[text1.length() + 1];

        for (int idx2 = text2.length() - 1; idx2 >= 0; idx2--) {
            for (int idx1 = text1.length() - 1; idx1 >= 0; idx1--) {
                int ans;

                if (text1.charAt(idx1) == text2.charAt(idx2)) {
                    ans = 1 + next[idx1 + 1];
                } else {
                    int case1 = next[idx1];
                    int case2 = curr[idx1 + 1];
                    ans = Math.max(case1, case2);
                }

                curr[idx1] = ans;
            }

            next = curr.clone();
        }

        return curr[0];
    }

    public static int solveUsingTabuSO2(String text1, String text2) {
        int next[] = new int[text2.length() + 1];
        int curr[] = new int[text2.length() + 1];

        for (int idx1 = text1.length() - 1; idx1 >= 0; idx1--) {
            for (int idx2 = text2.length() - 1; idx2 >= 0; idx2--) {
                int ans;

                if (text1.charAt(idx1) == text2.charAt(idx2)) {
                    ans = 1 + next[idx2 + 1];
                } else {
                    int case1 = curr[idx2 + 1];
                    int case2 = next[idx2];
                    ans = Math.max(case1, case2);
                }

                curr[idx2] = ans;
            }
            next = curr.clone();
        }

        return curr[0];
    }

    public static int longestPalindromeSubseq(String s) {
        StringBuilder text2 = new StringBuilder(s);
        text2.reverse();
        int ans = solveUsingTabuSO1(s, text2.toString());
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("bbbab"));
        System.out.println(longestPalindromeSubseq("cbbd"));
    }
}

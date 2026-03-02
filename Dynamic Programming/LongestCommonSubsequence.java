public class LongestCommonSubsequence {
    public static int solveUsingRec(String text1, String text2, int idx1, int idx2) {
        if (idx1 >= text1.length()) {
            return 0;
        }

        if (idx2 >= text2.length()) {
            return 0;
        }

        int ans;

        if (text1.charAt(idx1) == text2.charAt(idx2)) {
            ans = 1 + solveUsingRec(text1, text2, idx1 + 1, idx2 + 1);
        } else {
            int case1 = solveUsingRec(text1, text2, idx1, idx2 + 1);
            int case2 = solveUsingRec(text1, text2, idx1 + 1, idx2);
            ans = Math.max(case1, case2);
        }

        return ans;
    }

    public static int solveUsingMemo(String text1, String text2, int idx1, int idx2, int dp[][]) {
        if (idx1 >= text1.length()) {
            return 0;
        }

        if (idx2 >= text2.length()) {
            return 0;
        }

        if (dp[idx1][idx2] != -1) {
            return dp[idx1][idx2];
        }

        int ans;

        if (text1.charAt(idx1) == text2.charAt(idx2)) {
            ans = 1 + solveUsingMemo(text1, text2, idx1 + 1, idx2 + 1, dp);
        } else {
            int case1 = solveUsingMemo(text1, text2, idx1, idx2 + 1, dp);
            int case2 = solveUsingMemo(text1, text2, idx1 + 1, idx2, dp);
            ans = Math.max(case1, case2);
        }

        dp[idx1][idx2] = ans;

        return dp[idx1][idx2];
    }

    public static int solveUsingTabu(String text1, String text2) {
        int dp[][] = new int[text1.length() + 1][text2.length() + 1];

        for (int idx1 = text1.length() - 1; idx1 >= 0; idx1--) {
            for (int idx2 = text2.length() - 1; idx2 >= 0; idx2--) {
                int ans;

                if (text1.charAt(idx1) == text2.charAt(idx2)) {
                    ans = 1 + dp[idx1 + 1][idx2 + 1];
                } else {
                    int case1 = dp[idx1][idx2 + 1];
                    int case2 = dp[idx1 + 1][idx2];
                    ans = Math.max(case1, case2);
                }

                dp[idx1][idx2] = ans;
            }
        }

        return dp[0][0];
    }

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

    public static int longestCommonSubsequence(String text1, String text2) {
        // int idx1 = 0;
        // int idx2 = 0;
        // int ans = solveUsingRec(text1, text2, idx1, idx2);
        // int dp[][] = new int[text1.length() + 1][text2.length() + 1];
        // for (int[] row : dp) {
        // Arrays.fill(row, -1);
        // }
        // int ans = solveUsingMemo(text1, text2, idx1, idx2, dp);
        int ans = solveUsingTabuSO2(text1, text2);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
        System.out.println(longestCommonSubsequence("abc", "abc"));
        System.out.println(longestCommonSubsequence("abc", "def"));
    }
}

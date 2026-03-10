public class FindAllPossibleStableBinaryArrays1 {
    static int MOD = 1000000007;

    public static int solveUsingRec(int zero, int one, int prev, int cnt, int limit) {
        if (zero == 0 && one == 0) {
            return 1;
        }

        int ch1 = 0, ch2 = 0;

        if (prev == 0) {
            if (zero > 0 && cnt < limit) {
                ch1 = solveUsingRec(zero - 1, one, 0, cnt + 1, limit);
            }
            if (one > 0) {
                ch2 = solveUsingRec(zero, one - 1, 1, 1, limit);
            }
        } else if (prev == 1) {
            if (one > 0 && cnt < limit) {
                ch1 = solveUsingRec(zero, one - 1, 1, cnt + 1, limit);
            }
            if (zero > 0) {
                ch2 = solveUsingRec(zero - 1, one, 0, 1, limit);
            }
        }

        return (ch1 + ch2) % MOD;
    }

    public static int solveUsingMemo(int zero, int one, int prev, int cnt, int limit, int dp[][][][]) {
        if (zero == 0 && one == 0) {
            return 1;
        }

        if (dp[zero][one][prev][cnt] != -1) {
            return dp[zero][one][prev][cnt];
        }

        int ch1 = 0, ch2 = 0;

        if (prev == 0) {
            if (zero > 0 && cnt < limit) {
                ch1 = solveUsingMemo(zero - 1, one, 0, cnt + 1, limit, dp);
            }
            if (one > 0) {
                ch2 = solveUsingMemo(zero, one - 1, 1, 1, limit, dp);
            }
        } else if (prev == 1) {
            if (one > 0 && cnt < limit) {
                ch1 = solveUsingMemo(zero, one - 1, 1, cnt + 1, limit, dp);
            }
            if (zero > 0) {
                ch2 = solveUsingMemo(zero - 1, one, 0, 1, limit, dp);
            }
        }

        return dp[zero][one][prev][cnt] = (int) (((long) ch1 + ch2) % MOD);
    }

    public static int solveUsingTabu(int zero, int one, int limit) {
        int[][][][] dp = new int[zero + 1][one + 1][2][limit + 1];

        // base cases
        if (zero > 0) {
            dp[1][0][0][1] = 1;
        }
        if (one > 0) {
            dp[0][1][1][1] = 1;
        }

        for (int z = 0; z <= zero; z++) {
            for (int o = 0; o <= one; o++) {
                for (int prev = 0; prev <= 1; prev++) {

                    for (int cnt = 1; cnt <= limit; cnt++) {

                        int val = dp[z][o][prev][cnt];
                        if (val == 0)
                            continue;

                        if (prev == 0) {

                            // place another 0
                            if (z + 1 <= zero && cnt < limit) {
                                dp[z + 1][o][0][cnt + 1] = (dp[z + 1][o][0][cnt + 1] + val) % MOD;
                            }

                            // place 1
                            if (o + 1 <= one) {
                                dp[z][o + 1][1][1] = (dp[z][o + 1][1][1] + val) % MOD;
                            }

                        } else {

                            // place another 1
                            if (o + 1 <= one && cnt < limit) {
                                dp[z][o + 1][1][cnt + 1] = (dp[z][o + 1][1][cnt + 1] + val) % MOD;
                            }

                            // place 0
                            if (z + 1 <= zero) {
                                dp[z + 1][o][0][1] = (dp[z + 1][o][0][1] + val) % MOD;
                            }
                        }
                    }
                }
            }
        }

        int ans = 0;

        for (int cnt = 1; cnt <= limit; cnt++) {
            ans = (ans + dp[zero][one][0][cnt]) % MOD;
            ans = (ans + dp[zero][one][1][cnt]) % MOD;
        }

        return ans;
    }

    public static int numberOfStableArrays(int zero, int one, int limit) {
        // int startWithZero = solveUsingRec(zero - 1, one, 0, 1, limit);
        // int startWithOne = solveUsingRec(zero, one - 1, 1, 1, limit);

        // int[][][][] dp = new int[zero + 1][one + 1][2][limit + 1];

        // for (int i = 0; i <= zero; i++) {
        // for (int j = 0; j <= one; j++) {
        // for (int k = 0; k < 2; k++) {
        // for (int c = 0; c <= limit; c++) {
        // dp[i][j][k][c] = -1;
        // }
        // }
        // }
        // }

        // int startWithZero = solveUsingMemo(zero - 1, one, 0, 1, limit, dp);
        // int startWithOne = solveUsingMemo(zero, one - 1, 1, 1, limit, dp);

        // return (int) (((long) startWithZero + startWithOne) % MOD);

        return solveUsingTabu(zero, one, limit);
    }

    public static void main(String[] args) {
        System.out.println(numberOfStableArrays(1, 1, 2));
        System.out.println(numberOfStableArrays(1, 2, 1));
        System.out.println(numberOfStableArrays(3, 3, 2));
    }
}

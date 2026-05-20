public class SumOfBeautyOfAllSubstring {
    public static int bruteForce(String s) {
        int n = s.length();
        int sumOfBeauty = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int[] freq = new int[26];
                for (int k = i; k <= j; k++) {
                    freq[s.charAt(k) - 'a']++;
                }
                int maxi = Integer.MIN_VALUE;
                int mini = Integer.MAX_VALUE;
                for (int ch = 0; ch < 26; ch++) {
                    if (freq[ch] == 0) continue;
                    maxi = Math.max(maxi, freq[ch]);
                    mini = Math.min(mini, freq[ch]);
                }
                sumOfBeauty += (maxi - mini);
            }
        }

        return sumOfBeauty;
    }

    public static int optimized(String s) {
        int n = s.length();
        int sumOfBeauty = 0;

        int[][] freq = new int[26][n];

        for (int i = 0; i < n; i++) {
            for (int ch = 0; ch < 26; ch++) {
                freq[ch][i] = (i > 0) ? freq[ch][i - 1] : 0;
            }
            freq[s.charAt(i) - 'a'][i]++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int maxi = Integer.MIN_VALUE;
                int mini = Integer.MAX_VALUE;

                for (int ch = 0; ch < 26; ch++) {
                    int diff = freq[ch][j] - (i > 0 ? freq[ch][i - 1] : 0);
                    if (diff > 0) {
                        maxi = Math.max(maxi, diff);
                        mini = Math.min(mini, diff);
                    }
                }

                sumOfBeauty += (maxi - mini);
            }
        }

        return sumOfBeauty;
    }

    public static int optimized2(String s) {
        int n = s.length();
        int sumOfBeauty = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];

            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;

                int maxi = Integer.MIN_VALUE;
                int mini = Integer.MAX_VALUE;

                for (int ch = 0; ch < 26; ch++) {
                    int diff = freq[ch];
                    if (diff > 0) {
                        maxi = Math.max(maxi, diff);
                        mini = Math.min(mini, diff);
                    }
                }

                sumOfBeauty += (maxi - mini);
            }
        }

        return sumOfBeauty;
    }

    public static int beautySum(String s) {
        return optimized(s);
    }

    public static void main(String[] args) {
        System.out.println(beautySum("aabcb"));
        System.out.println(beautySum("aabcbaa"));
    }
}

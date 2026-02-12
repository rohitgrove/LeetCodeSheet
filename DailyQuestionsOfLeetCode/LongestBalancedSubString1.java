public class LongestBalancedSubString1 {
    public static int longestBalanced(String s) {
        int n = s.length();
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            int distinctCount = 0;
            int maxFreq = 0;

            for (int j = i; j < n; j++) {
                int index = s.charAt(j) - 'a';

                if (freq[index] == 0) {
                    distinctCount++;
                }

                freq[index]++;
                maxFreq = Math.max(maxFreq, freq[index]);

                int length = j - i + 1;

                // Balanced condition
                if (length == distinctCount * maxFreq) {
                    maxLength = Math.max(maxLength, length);
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(longestBalanced("abbac"));
        System.out.println(longestBalanced("zzabccy"));
        System.out.println(longestBalanced("aba"));
    }
}

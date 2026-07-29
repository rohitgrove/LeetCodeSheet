public class SmallestPalindormicRearrangement2 {
    static final long LIMIT = 1000000L;

    public static long comb(int left, int x) {
        if (x < 0 || x > left) {
            return 0;
        }

        x = Math.min(x, left - x);

        long res = 1;

        for (int i = 1; i <= x; i++) {
            res = res * (left - x + i) / i;
            if (res >= LIMIT) {
                return LIMIT;
            }
        }

        return res;
    }

    public static long countWays(int[] half) {
        int left = 0;
        for (int num : half) {
            left += num;
        }

        long ways = 1;

        for (int x : half) {
            if (x == 0) {
                continue;
            }

            ways *= comb(left, x);

            if (ways >= LIMIT) {
                return LIMIT;
            }

            left -= x;
        }

        return ways;
    }

    public static String smallestPalindrome(String s, int k) {
        int[] freq = new int[26];
        int[] half = new int[26];
        char mid = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            half[i] = freq[i] / 2;

            if ((freq[i] & 1) == 1) {
                mid = (char) ('a' + i);
            }
        }

        if (countWays(half) < k) {
            return "";
        }

        StringBuilder first = new StringBuilder();

        int len = s.length() / 2;

        while (first.length() < len) {
            for (int c = 0; c < 26; c++) {
                if (half[c] == 0) {
                    continue;
                }

                half[c]--;

                long ways = countWays(half);

                if (ways >= k) {
                    first.append((char) ('a' + c));
                    break;
                }

                k -= ways;
                half[c]++; // restore only if not chosen
            }
        }

        StringBuilder ans = new StringBuilder(first);

        if (mid != 0) {
            ans.append(mid);
        }

        ans.append(new StringBuilder(first).reverse());

        return ans.toString();
    }

    public static void main(String[] args) {

        System.out.println(smallestPalindrome("abba", 1)); // abba
        System.out.println(smallestPalindrome("abba", 2)); // baab
        System.out.println(smallestPalindrome("aa", 2)); // ""
        System.out.println(smallestPalindrome("bacab", 1)); // abcba
        System.out.println(smallestPalindrome("bacab", 2)); // bacab
    }
}
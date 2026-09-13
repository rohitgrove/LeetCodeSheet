public class MinimumOperationsToMakeEveryElementPalindromicWrongVersion {
    public static long minOperations(int[] nums) {
        long ans = 0;

        for (int num : nums) {
            ans += getMinOperations(num);
        }

        return ans;
    }

    public static long getMinOperations(int num) {
        long x = num;
        String str = String.valueOf(num);
        int len = str.length();

        int half = (len + 1) / 2;
        long power = 1;
        for (int i = 0; i < len - half; i++) {
            power *= 10;
        }
        long prefix = x / power;
        long best = Long.MAX_VALUE;

        for (long p = prefix - 1; p <= prefix + 1; p++) {
            if (p < power / 10) {
                continue;
            }

            long palindrome = makePalindrome(p, len);

            if (palindrome > 0 && palindrome % 2 == x % 2) {
                long diff = Math.abs(x - palindrome);
                best = Math.min(best, diff / 2);
            }
        }

        if (len > 1) {

            int newLen = len - 1;

            long palindrome;

            if (x % 2 == 0) {
                palindrome = largestPalindrome(newLen, false);
            } else {
                palindrome = largestPalindrome(newLen, true);
            }

            if (palindrome > 0) {
                long diff = Math.abs(x - palindrome);
                best = Math.min(best, diff / 2);
            }
        }

        int newLen = len + 1;

        long palindrome;

        if (x % 2 == 0) {
            palindrome = smallestPalindrome(newLen, false);
        } else {
            palindrome = smallestPalindrome(newLen, true);
        }

        long diff = Math.abs(x - palindrome);

        best = Math.min(best, diff / 2);

        return best;
    }

    public static long makePalindrome(long prefix, int len) {
        String s = String.valueOf(prefix);

        StringBuilder sb = new StringBuilder(s);

        int start;

        if (len % 2 == 0) {
            start = s.length() - 1;
        } else {
            start = s.length() - 2;
        }

        for (int i = start; i >= 0; i--) {
            sb.append(s.charAt(i));
        }

        return Long.parseLong(sb.toString());
    }

    public static long largestPalindrome(int len, boolean odd) {
        int firstDigit;

        if (odd) {
            firstDigit = 9;
        } else {
            firstDigit = 8;
        }

        int half = (len + 1) / 2;
        StringBuilder prefix = new StringBuilder();

        prefix.append(firstDigit);
        for (int i = 1; i < half; i++) {
            prefix.append('9');
        }

        return makePalindrome(Long.parseLong(prefix.toString()), len);
    }

    public static long smallestPalindrome(int len, boolean odd) {
        int firstDigit;
        if (odd) {
            firstDigit = 1;
        } else {
            firstDigit = 2;
        }

        int half = (len + 1) / 2;

        StringBuilder prefix = new StringBuilder();

        prefix.append(firstDigit);

        for (int i = 1; i < half; i++) {
            prefix.append('0');
        }

        return makePalindrome(Long.parseLong(prefix.toString()), len);
    }

    public static void main(String[] args) {
        int nums1[] = { 10, 12, 14, 16 };
        System.out.println(minOperations(nums1));
        int nums2[] = { 9, 10, 11, 10 };
        System.out.println(minOperations(nums2));
        int nums3[] = { 125 };
        System.out.println(minOperations(nums3));
    }
}

public class SmallestPalindormicRearrangement1 {
    public static String smallestPalindrome(String s) {
        int n = s.length(), left = 0;
        int[] freq = new int[26];
        char[] chars = s.toCharArray();

        for (int i = 0; i < n / 2; i++) {
            freq[chars[i] - 'a']++;
        }

        int right = n - 1;
        for (int i = 0; i < 26; i++) {
            while (freq[i]-- > 0) {
                chars[left++] = (char) (97 + i);
                chars[right--] = (char) (97 + i);
            }
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(smallestPalindrome("z"));
        System.out.println(smallestPalindrome("babab"));
        System.out.println(smallestPalindrome("daccad"));
        System.out.println(smallestPalindrome("yey"));
    }
}

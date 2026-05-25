public class PalindromicSubstrings {
    public static int expand(String s, int i, int j) {
        int count = 0;

        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
            count++;
        }

        return count;
    }

    public static int countSubstrings(String s) {
        int totalCount = 0;

        for (int center = 0; center < s.length(); center++) {
            int odd = expand(s, center, center);
            int even = expand(s, center, center + 1);
            totalCount = totalCount + odd + even;
        }

        return totalCount;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("abc"));
        System.out.println(countSubstrings("aaa"));
    }
}
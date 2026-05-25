public class LongestHappyPrefix {
    public static String bruteForce(String s) {
        // The goal is to find the longest substring that exists at both the start and
        // end of the string, but it must not be the entire string itself. In the brute
        // force approach, we try all possible lengths of such substrings, beginning
        // with the longest possible and gradually reducing the size. At each step, we
        // compare a prefix from the beginning with a suffix from the end. As soon as we
        // find a match, we return it, since we are checking from longest to shortest.
        // This method is simple but not optimal for very large strings.
        // Check for every possible substring starting from the beginning of the string.
        // For each such substring, check if the same substring also appears at the end
        // of the string.
        // Start checking from the longest possible substring and move to shorter ones.
        // Return the first substring that appears at both the start and end.
        // If no such substring exists, return an empty result.
        int n = s.length();

        for (int len = n - 1; len >= 0; len--) {
            if (s.substring(0, len).equals(s.substring(n - len))) {
                return s.substring(0, len);
            }
        }

        return "";
    }

    public static String optimizedApproach(String s) {
        int[] lps = new int[s.length()];

        // Pointer to track length of previous longest prefix suffix
        int len = 0;

        // Start from second character
        for (int i = 1; i < s.length(); i++) {
            // If characters match, extend the match and update lps
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
            }
            // If mismatch occurs and len is not zero, fallback using lps
            else if (len != 0) {
                len = lps[len - 1];
                i--; // retry with same i
            }
            // If no match and len is 0, lps remains 0
        }

        // Return the prefix using the value from the end of the lps array
        return s.substring(0, lps[s.length() - 1]);
    }

    public static String longestPrefix(String s) {
        return optimizedApproach(s);
    }

    public static void main(String[] args) {
        System.out.println(longestPrefix("level"));
        System.out.println(longestPrefix("ababab"));
    }
}

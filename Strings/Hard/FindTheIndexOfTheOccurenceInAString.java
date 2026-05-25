public class FindTheIndexOfTheOccurenceInAString {
    public static int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        for (int i = 0; i <= n - m; i++) {
            for (int j = 0; j < m; j++) {
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }
                if (j == m - 1) {
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad"));
        System.out.println(strStr("leetcode", "leeto"));
    }
}

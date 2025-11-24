public class SubstringsOfSizeThreeWithDistinctCharacters {
    public static boolean isGoodString(String str, int s, int e) {
        for (int i = s; i < e; i++) {
            for (int j = i + 1; j < e; j++) {
                if (str.charAt(j) == str.charAt(i)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static int countGoodSubstrings(String str) {
        if (str.length() < 3) {
            return 0;
        }
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (i + 3 <= str.length()) {
                // String subString = str.substring(i, i + 3);
                if (isGoodString(str, i, i + 3)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static int countGoodSubstrings2(String str) {
        if (str.length() < 3) {
            return 0;
        }
        int count = 0;

        for (int i = 0; i <= str.length() - 3; i++) {
            if (str.charAt(i) != str.charAt(i + 1) && str.charAt(i + 1) != str.charAt(i + 2)
                    && str.charAt(i) != str.charAt(i + 2)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String s1 = "xyzzaz";
        System.out.println(s1 + " : " + countGoodSubstrings2(s1));
        String s2 = "aababcabc";
        System.out.println(s2 + " : " + countGoodSubstrings(s2));
    }
}

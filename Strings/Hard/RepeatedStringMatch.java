public class RepeatedStringMatch {
    public static int repeatedStringMatch(String a, String b) {
        String strA = a;
        int repeat = b.length() / a.length();
        int count = 1;
        for (int i = 0; i < repeat + 2; i++) {
            if (a.contains(b)) {
                return count;
            } else {
                a += strA;
                count++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(repeatedStringMatch("abcd", "cdabcdab"));
    }
}

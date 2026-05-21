public class CountAndSay {
    public static String countAndSayItr(int n) {
        String result = "1";
        for (int i = 1; i < n; i++) {
            result = describe(result);
        }
        return result;
    }

    public static String countAndSayRec(int n) {
        if (n == 1) return "1";
        return describe(countAndSayRec(n - 1));
    }

    public static String describe(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                sb.append(count).append(s.charAt(i - 1));
                count = 1;
            }
        }

        sb.append(count).append(s.charAt(s.length() - 1));
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSayRec(4));
        System.out.println(countAndSayRec(1));
    }
}

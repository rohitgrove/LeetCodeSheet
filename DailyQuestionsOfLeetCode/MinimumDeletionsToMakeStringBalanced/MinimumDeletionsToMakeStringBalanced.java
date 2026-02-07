public class MinimumDeletionsToMakeStringBalanced {
    public static int minimumDeletions(String s) {
        int res = 0, b = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'b') {
                b++;
            } else if (b > 0) {
                res++;
                b--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(minimumDeletions("aababbab"));
        System.out.println(minimumDeletions("bbaaaaabb"));
    }
}

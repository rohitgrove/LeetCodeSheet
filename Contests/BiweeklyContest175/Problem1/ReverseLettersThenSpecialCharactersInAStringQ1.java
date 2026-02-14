public class ReverseLettersThenSpecialCharactersInAStringQ1 {
    public static String reverseByType(String s) {
        int n = s.length();
        char[] res = new char[n];

        StringBuilder letters = new StringBuilder();
        StringBuilder specials = new StringBuilder();

        // Step 1: collect letters & special characters
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                letters.append(c);
            } else {
                specials.append(c);
            }
        }

        // Step 2: reverse both
        letters.reverse();
        specials.reverse();

        // Step 3: place back to original positions
        int li = 0, si = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                res[i] = letters.charAt(li++);
            } else {
                res[i] = specials.charAt(si++);
            }
        }

        return new String(res);
    }

    public static void main(String[] args) {
        System.out.println(reverseByType(")ebc#da@f("));
        System.out.println(reverseByType("z"));
        System.out.println(reverseByType("!@#$%^&*()"));
    }
}

import java.util.Stack;

public class ReverseWordsInAString {
    public static String reverseWords(String s) {
        String strs[] = s.trim().split("\\s+");

        StringBuilder res = new StringBuilder();
        for (int i = strs.length - 1; i >= 1; i--) {
            String word = strs[i] + " ";
            res.append(word);
        }

        res.append(strs[0]);

        return res.toString();
    }

    public static String reverseWords2(String s) {
        String strs[] = s.split(" ");
        Stack<String> st = new Stack<>();

        for (int i = 0; i < strs.length; i++) {
            if (!strs[i].isEmpty()) {
                if (i != strs.length - 1) {
                    st.push(" " + strs[i]);
                } else {
                    st.push(strs[i]);
                }
            }
        }

        StringBuilder res = new StringBuilder();

        while (!st.isEmpty()) {
            res.append(st.pop());
        }

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords2("the sky is blue"));
        System.out.println(reverseWords2("  hello world  "));
        System.out.println(reverseWords2("a good   example"));
    }
}

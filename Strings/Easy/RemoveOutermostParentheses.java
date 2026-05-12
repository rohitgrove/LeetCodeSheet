public class RemoveOutermostParentheses {
    public static String removeOuterParentheses(String s) {
        StringBuilder res = new StringBuilder();

        int level = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // If we encounter '(', increase the level
            if (ch == '(') {
                // If we're inside a primitive, add '(' to result
                if (level > 0) {
                    res.append(ch);
                }
                // Increase the nesting level for '('
                level++;
            } else if (ch == ')') {
                // Decrease the nesting level for ')'
                level--;
                // If we're inside a primitive, add ')' to result
                if (level > 0) {
                    res.append(ch);
                }
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())"));
        System.out.println(removeOuterParentheses("(()())(())(()(()))"));
        System.out.println(removeOuterParentheses("()()"));
    }
}

public class MaximumNestingOfTheParentheses {
    public static int maxDepth(String s) {
        int depth = 0;
        int r = 0;
        for (char c : s.toCharArray()) {
            if (c == ')') {
                depth--;
                continue;
            }
            // Digits and operators
            if (c != '(') {
                continue;
            }
            depth++;
            // New max only possible after '('
            if (depth > r) {
                r = depth;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(maxDepth("(1+(2*3)+((8)/4))+1"));
        System.out.println(maxDepth("(1)+((2))+(((3)))"));
        System.out.println(maxDepth("()(())((()()))"));
    }
}

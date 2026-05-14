public class MaximumNestingDepthofParenthesis {
    public static int maxDepth(String s) {
        int bracket = 0;
        int maxCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                bracket++;
            } else if (ch == ')') {
                bracket--;
            }

            maxCount = Math.max(maxCount, bracket);
        }

        return maxCount;
    }

    public static void main(String[] args) {
        System.out.println(maxDepth("(1+(2*3)+((8)/4))+1"));
        System.out.println(maxDepth("(1)+((2))+(((3)))"));
        System.out.println(maxDepth("()(())((()()))"));
    }
}

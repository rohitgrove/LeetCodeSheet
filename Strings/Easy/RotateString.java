public class RotateString {
    public static boolean bruteForcw(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            String rotated = s.substring(i) + s.substring(0, i);
            if (rotated.equals(goal)) {
                return true;
            }
        }

        return false;
    }

    public static boolean optimized(String s, String goal) {
        String str = goal + goal;
        if (s.length() != goal.length()) {
            return false;
        }

        return str.contains(s);
    }

    public static boolean rotateString(String s, String goal) {
        return optimized(s, goal);
    }

    public static void main(String[] args) {
        System.out.println(rotateString("abcde", "cdeab"));
        System.out.println(rotateString("abcde", "abced"));
    }
}

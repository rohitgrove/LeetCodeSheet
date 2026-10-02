public class CheckPalindorme {
    public static boolean solveUsingPalindrome(String str, int s, int e) {
        if (s > e) {
            return true;
        }

        if (str.charAt(s) != str.charAt(e)) {
            return false;
        } else {
            return solveUsingPalindrome(str, s + 1, e - 1);
        }
    }

    public static boolean isPalindrome(String str) {
        str = str.toLowerCase().replaceAll("[^a-z0-9]", "");
        int s = 0;
        int e = str.length() - 1;
        return solveUsingPalindrome(str, s, e);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
    }
}

public class ValidPalindrome {
    public static boolean isPalindromeITR(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char leftCharacter = s.charAt(left);
            char rightCharacter = s.charAt(right);
            if (!Character.isLetterOrDigit(leftCharacter)) {
                left++;
            } else if (!Character.isLetterOrDigit(rightCharacter)) {
                right--;
            } else {
                if (Character.toLowerCase(leftCharacter) != Character.toLowerCase(rightCharacter)) {
                    return false;
                }
                left++;
                right--;
            }
        }

        return true;
    }

    public static boolean isPalindromeREC(String s, int left, int right) {
        // Base case
        if (left >= right) {
            return true;
        }

        char leftCharacter = s.charAt(left);
        char rightCharacter = s.charAt(right);

        // Skip non-alphanumeric from left
        if (!Character.isLetterOrDigit(leftCharacter)) {
            return isPalindromeREC(s, left + 1, right);
        }

        // Skip non-alphanumeric from right
        if (!Character.isLetterOrDigit(rightCharacter)) {
            return isPalindromeREC(s, left, right - 1); // FIXED
        }

        // Compare characters (case-insensitive)
        if (Character.toLowerCase(leftCharacter) != Character.toLowerCase(rightCharacter)) {
            return false;
        }

        // Move both pointers
        return isPalindromeREC(s, left + 1, right - 1);
    }

    public static boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        return isPalindromeREC(s, left, right);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}

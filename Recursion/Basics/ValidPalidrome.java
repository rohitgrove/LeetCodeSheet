public class ValidPalidrome {
    public static boolean isPalindromeRec(String s, int left, int right) {
        if (left >= right) {
            return true;
        }

        char leftCharacter = s.charAt(left);
        char rightCharacter = s.charAt(right);

        if (!Character.isLetterOrDigit(leftCharacter)) {
            return isPalindromeRec(s, left + 1, right);
        } else if (!Character.isLetterOrDigit(rightCharacter)) {
            return isPalindromeRec(s, left, right - 1);
        }

        if (Character.toLowerCase(leftCharacter) != Character.toLowerCase(rightCharacter)) {
            return false;
        }

        return isPalindromeRec(s, left + 1, right - 1);
    }

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

    public static boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }

        return isPalindromeITR(s);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
    }
}

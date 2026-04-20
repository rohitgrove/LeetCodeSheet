public class PalindormeNumber {
    public static int reverse(int n) {
        int ans = 0;

        while (n != 0) {
            int digit = n % 10;
            ans = (ans * 10) + digit;
            n = n / 10;
        }

        return ans;
    }

    public static boolean isPalindromeBruteForce(int n ) {
        if (n < 0) {
            return false;
        }

        int palidromeNum = reverse(n);

        while (n != 0) {
            int digit1 = n % 10;
            int digit2 = palidromeNum % 10;

            if (digit1 != digit2) {
                return false;
            }

            n = n / 10;
            palidromeNum = palidromeNum / 10;
        }

        return true;
    }

    public static boolean isPalindromeOptimized(int n ) {
        if (n < 0) {
            return false;
        }

        int palidromeNum = reverse(n);

        return n == palidromeNum;
    }

    public static boolean isPalindrome(int n) {
        return isPalindromeOptimized(n);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
    }
}

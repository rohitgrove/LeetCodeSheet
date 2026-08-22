public class PalindromeANumber {
    public static int rev(int n) {
        long ans = 0;

        while (n != 0) {
            int digit = n % 10;
            ans = 10 * ans + digit;
            n = n / 10;
        }

        return (int) ans;
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int revADigit = rev(x);
        return revADigit == x;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
    }
}

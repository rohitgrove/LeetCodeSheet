public class ReverseAInteger {
    public static int reverse(int x) {
        long ans = 0;

        while (x != 0) {
            int digit = x % 10;
            ans = 10 * ans + digit;
            x = x / 10;
        }

        if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
    }
}

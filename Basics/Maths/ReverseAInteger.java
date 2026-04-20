public class ReverseAInteger {
    public static int reverse(int n) {
        int ans = 0;

        while (n != 0) {
            int digit = n % 10;
            if ((ans > Integer.MAX_VALUE / 10) || (ans < Integer.MIN_VALUE / 10)) {
                return 0;
            }
            ans = (ans * 10) + digit;
            n = n / 10;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
    }
}

public class SumOfDigits {
    public static int sumOfDigit(int n) {
        if (n == 0) {
            return 0;
        }

        int digit = n % 10;

        return digit + sumOfDigit(n / 10);
    }

    public static int sum(int n) {
        return sumOfDigit(Math.abs(n));
    }

    public static void main(String[] args) {
        System.out.println(sum(1234));
        System.out.println(sum(-507));
    }
}

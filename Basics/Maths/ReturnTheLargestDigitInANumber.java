public class ReturnTheLargestDigitInANumber {
    public static int largestDigit(int n) {
        int largestDigit = 0;
        while (n != 0) {
            int digit = n % 10;
            largestDigit = Math.max(largestDigit, digit);
            n = n / 10;
        }

        return largestDigit;
    }

    public static void main(String[] args) {
        System.out.println(largestDigit(25));
        System.out.println(largestDigit(99));
    }
}

public class CheckDivisibilityByDigitSumAndProduct {
    public static boolean checkDivisibility(int n) {
        int sumOfDigits = 0;
        int prodOfDigits = 1;
        int backup = n;

        while (n != 0) {
            int digit = n % 10;
            sumOfDigits += digit;
            prodOfDigits *= digit;
            n = n / 10;
        }

        int total = sumOfDigits + prodOfDigits;
        return backup % total == 0;
    }

    public static void main(String[] args) {
        System.out.println(checkDivisibility(99));
        System.out.println(checkDivisibility(23));
    }
}

public class CountNumberOfOddDigitsInANumber {
    public static int countOddDigit(int n) {
        int cod = 0;
        while (n != 0) {
            int digit = n % 10;
            if (digit % 2 != 0) {
                cod++;
            }
            n = n / 10;
        }

        return cod;
    }

    public static void main(String[] args) {
        System.out.println(countOddDigit(5));
        System.out.println(countOddDigit(25));
    }
}

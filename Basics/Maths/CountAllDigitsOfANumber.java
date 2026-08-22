public class CountAllDigitsOfANumber {
    public static int numOfDigit(int n) {
        int nod = 0;
        while (n != 0) {
            n = n / 10;
            nod++;
        }

        return nod;
    }

    public static int numOfDigitOptimized(int n) {
        int cnt = (int) (Math.log10(n) + 1);
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(numOfDigit(12345));
        System.out.println(numOfDigit(7789));
        System.out.println(numOfDigitOptimized(12345));
        System.out.println(numOfDigitOptimized(7789));
    }
}

public class CountAllDigitsOfANumber {
    public static int countDigits(int n) {
        int count = 0;

        while (n > 0) {
            count++;
            n = n / 10;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countDigits(1));
        System.out.println(countDigits(99999));
        System.out.println(countDigits(12345));
    }
}

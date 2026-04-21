public class SumOfNaturalNumbers {
    public static int sumOfNaturalNumbers(int n) {
        if (n == 1) {
            return 1;
        }

        return n + sumOfNaturalNumbers(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(sumOfNaturalNumbers(5));
        System.out.println(sumOfNaturalNumbers(6));
    }
}

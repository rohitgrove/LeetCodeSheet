public class SumOfNNaturalNumbers {
    public static int sumOfNuturalNumbersUsingITR(int N) {
        int sum = 0;

        for (int i = 1; i <= N; i++) {
            sum += i;
        }

        return sum;
    }

    public static int sumOfNuturalNumbersUsingFormula(int N) {
        return (N * (N + 1)) / 2;
    }

    public static int sumOfNuturalNumbersUsingRec(int N) {
        if (N == 0) {
            return 0;
        }

        return N + sumOfNuturalNumbersUsingRec(N - 1);
    }

    public static void main(String[] args) {
        System.out.println(sumOfNuturalNumbersUsingITR(5));
        System.out.println(sumOfNuturalNumbersUsingITR(6));
        System.out.println(sumOfNuturalNumbersUsingFormula(5));
        System.out.println(sumOfNuturalNumbersUsingFormula(6));
        System.out.println(sumOfNuturalNumbersUsingRec(5));
        System.out.println(sumOfNuturalNumbersUsingRec(6));
    }
}

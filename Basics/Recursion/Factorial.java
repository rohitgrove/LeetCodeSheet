public class Factorial {
    public static int factorialIteraive(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }

        return fact;
    }

    public static int factorialRec(int n) {
        if (n == 1) {
            return 1;
        }

        return n * factorialIteraive(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(factorialIteraive(5));
        System.out.println(factorialIteraive(3));
        System.out.println(factorialRec(5));
        System.out.println(factorialRec(3));
    }
}

public class FibbonacciSires {
    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return fib(n - 1) + fib(n - 2);
    }

    public static int fibITR(int n) {
        if (n <= 1) {
            return n;
        }
        int step1 = 0;
        int step2 = 1;

        for (int i = 2; i <= n; i++) {
            int next = step1 + step2;
            step1 = step2;
            step2 = next;
        }

        return step2;
    }

    public static void main(String[] args) {
        System.out.println(fib(2));
        System.out.println(fib(3));
        System.out.println(fib(4));
    }
}

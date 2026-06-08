public class Pow {
    public static double bruteForce(double x, int n) {
        // Base case: any number to the power of 0 is 1
        if (n == 0 || x == 1.0) {
            return 1;
        }
        long temp = n; // to avoid integer overflow

        // Handle negative exponents
        if (n < 0) {
            x = 1 / x;
            temp = -1L * n;
        }

        double ans = 1;

        for (long i = 0; i < temp; i++) {
            // Multiply ans by x for n times
            ans *= x;
        }
        return ans;
    }

    public static double myPow(double x, int n) {
        return bruteForce(x, n);
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.00000, 10));
        System.out.println(myPow(2.10000, 3));
        System.out.println(myPow(2.00000, -2));
    }
}

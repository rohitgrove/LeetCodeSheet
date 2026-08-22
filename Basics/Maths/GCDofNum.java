public class GCDofNum {
    public static int findGcdBruteForce(int n1, int n2) {
        int gcd = 1;

        // Iterate from 1 up to
        // the minimum of n1 and n2
        for (int i = 1; i <= Math.min(n1, n2); i++) {
            // Check if i is a common
            // factor of both n1 and n2
            if (n1 % i == 0 && n2 % i == 0) {
                // Update gcd to the
                // current common factor i
                gcd = i;
            }
        }

        // Return the greatest
        // common divisor (gcd)
        return gcd;
    }

    public static int findGcdBetterAppraoch(int n1, int n2) {
        // Iterate from the minimum of
        // n1 and n2 down to 1
        // Start from the minimum of n1 and n2
        // because the GCD cannot
        // exceed the smaller number
        for (int i = Math.min(n1, n2); i > 0; i--) {
            // Check if i is a common
            // factor of both n1 and n2
            if (n1 % i == 0 && n2 % i == 0) {
                // If i is a common factor,
                // return it as the GCD
                return i;
            }
        }
        // If no common factors are found,
        // return 1 (as 1 is always a
        // divisor of any number)
        return 1;
    }

    public static int findGcd(int n1, int n2) {
        return findGcdBetterAppraoch(n1, n2);
    }

    public static void main(String[] args) {
        System.out.println("GCD of " + 9 + " and " + 12 + " is: " + findGcd(9, 12));
        System.out.println("GCD of " + 20 + " and " + 15 + " is: " + findGcd(20, 15));
    }
}

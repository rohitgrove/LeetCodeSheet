public class CheckForPrimeNumber {
    public static boolean checkPrime(int n) {
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                cnt++;
            }
        }

        return cnt == 2;
    }

    public static boolean checkPrimeOptimal(int n) {
        int cnt = 0;  // Initialize a counter variable to count the number of factors

        // Loop through numbers from 1 to the square root of n
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                cnt++;  // If n is divisible by i, increment the counter

                // If n is not a perfect square, count its reciprocal factor
                if (n / i != i) {
                    cnt++;
                }
            }
        }

        // If the number of factors is exactly 2 (1 and the number itself), it's prime
        return cnt == 2;
    }

    public static void main(String[] args) {
        System.out.println(checkPrime(2));
        System.out.println(checkPrime(10));
        System.out.println(checkPrime(1483));
        
        System.out.println(checkPrimeOptimal(2));
        System.out.println(checkPrimeOptimal(10));
        System.out.println(checkPrimeOptimal(1483));

    }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllDivisorsOfANumber {
    public static void print_divisors(int n) {
        for (int i = 1; i <= n; i++) {
            if ((n % i) == 0) {
                System.out.print(i + " ");
            }
        }
    }

    public static void print_divisorsOptimized(int n) { // tc: O(√n)
        List<Integer> divisors = new ArrayList<>();

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);

                // Avoid duplicate when i == n/i
                if (i != n / i) {
                    divisors.add(n / i);
                }
            }
        }

        Collections.sort(divisors);
        for (int d : divisors) {
            System.out.print(d + " ");
        }
    }

    public static void main(String[] args) {
        print_divisorsOptimized(20);
        print_divisorsOptimized(21191);
    }
}

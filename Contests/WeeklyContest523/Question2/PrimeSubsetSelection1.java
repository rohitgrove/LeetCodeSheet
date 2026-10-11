import java.util.ArrayList;
import java.util.List;

public class PrimeSubsetSelection1 {
    public static List<Integer> maxPrimes(int n, int s) {
        List<Integer> ans = new ArrayList<>();
        int sum = 0;

        for (int num = 2; num <= n; num++) {
            boolean prime = true;

            for (int j = 2; j * j <= num; j++) {
                if (num % j == 0) {
                    prime = false;
                    break;
                }
            }

            if (prime) {
                if (sum + num > s) {
                    break;
                }

                sum += num;
                ans.add(num);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxPrimes(7, 20)); 
        System.out.println(maxPrimes(15, 15)); 
        System.out.println(maxPrimes(5, 1)); 
        System.out.println(maxPrimes(10, 10)); 
        System.out.println(maxPrimes(2, 2)); 
        System.out.println(maxPrimes(3, 3)); 
    }
}

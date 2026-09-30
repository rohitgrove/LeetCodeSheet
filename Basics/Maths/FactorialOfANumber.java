public class FactorialOfANumber {
    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        
        int ans = 1;
        for (int i = 1; i <= n; i++) {
            ans *= i;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(factorial(2));
        System.out.println(factorial(1));
        System.out.println(factorial(4));
        System.out.println(factorial(5));
    }
}

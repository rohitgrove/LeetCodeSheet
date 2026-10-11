public class ThreeFibonacciSum {
    public static boolean threeFibonacciSum(int n) {
        int a = 0, b = 1, c = 1;

        while (a + b + c <= n) {
            if (a + b + c == n) {
                return true;
            }

            int next = b + c;
            a = b;
            b = c;
            c = next;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(threeFibonacciSum(16));
        System.out.println(threeFibonacciSum(8));
        System.out.println(threeFibonacciSum(2));
        System.out.println(threeFibonacciSum(1));
        System.out.println(threeFibonacciSum(3));
        System.out.println(threeFibonacciSum(10));
    }
}
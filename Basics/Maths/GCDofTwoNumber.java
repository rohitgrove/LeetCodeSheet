public class GCDofTwoNumber {
    public static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }

        if (b == 0) {
            return a;
        }

        while (a != 0 && b != 0) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }

        return a == 0 ? b : a;
    }

    public static void main(String[] args) {
        System.out.println(gcd(20, 28)); // 4
        System.out.println(gcd(60, 36)); // 12
        System.out.println(gcd(12, 18)); // 6
        System.out.println(gcd(30, 15)); // 15
        System.out.println(gcd(4, 9)); // 1
    }
}

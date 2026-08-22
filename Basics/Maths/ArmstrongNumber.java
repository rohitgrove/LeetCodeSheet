public class ArmstrongNumber {
    public static int numberOfDigits(int n) {
        int ans = 0;
        while (n != 0) {
            n = n / 10;
            ans++;
        }

        return ans;
    }

    public static boolean armstrongNumber(int n) {
        int nod = numberOfDigits(n);
        int backup = n;
        int ans = 0;

        while (n != 0) {
            int digit = n % 10;
            ans += Math.pow(digit, nod);
            n = n / 10;
        }

        return ans == backup;
    }

    public static void printTill(int n) {
        for (int i = 1; i <= 1000; i++) {
            if (armstrongNumber(i)) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(armstrongNumber(153));
        System.out.println(armstrongNumber(372));
        System.out.println(armstrongNumber(100));

        printTill(1000);
    }
}

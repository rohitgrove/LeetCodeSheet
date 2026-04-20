public class Armstrong {
    public static void printTill(int n) {
        for (int i = 1; i <= n; i++) {
            if (isArmstrong(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isArmstrong(int n) {
        int nod = numOfDigits(n);
        int backup = n;

        int ans = 0;
        while (n != 0) {
            int digit = n % 10;
            ans += (int) Math.pow(digit, nod);
            n = n / 10;
        }

        return ans == backup;
    }

    public static int numOfDigits(int n) {
        int ans = 0;

        while (n != 0) {
            ans++;
            n = n / 10;
        }

        return ans;
    }

    public static void main(String[] args) {
        printTill(1000);
    }
}

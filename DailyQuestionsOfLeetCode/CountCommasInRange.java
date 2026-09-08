public class CountCommasInRange {
    public static int bruteFoece(int n) {
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (i >= 1000) {
                count++;
            }
        }

        return count;
    }

    public static int optimizedApproach(int n) {
        if (n < 1000) {
            return 0;
        }

        return n - 999;
    }

    public static int countCommas(int n) {
        return optimizedApproach(n);
    }

    public static void main(String[] args) {
        System.out.println(countCommas(1002));
        System.out.println(countCommas(998));
    }
}

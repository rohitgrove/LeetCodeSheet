public class CountCommasInRange2 {
    public static long countCommas(long n) {
        long ans = 0;
        long power = 1000;

        while (power <= n) {
            ans += n - power + 1;

            // Next comma position: 1000 -> 1000000 -> 1000000000
            if (power > Long.MAX_VALUE / 1000) {
                break;
            }

            power *= 1000;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countCommas(1002));
        System.out.println(countCommas(998));
    }
}

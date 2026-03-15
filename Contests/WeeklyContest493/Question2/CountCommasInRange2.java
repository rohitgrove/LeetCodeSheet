public class CountCommasInRange2 {
    public static long countCommas(long n) {
        long res = 0;
        long start = 1000;
        int commas = 1;

        while (start <= n) {
            long end = Math.min(n, start * 1000 - 1);
            res += (end - start + 1) * commas;
            start *= 1000;
            commas++;
        }

        return res;
    }

    public static void main(String[] args) {
        int n1 = 1002;
        System.out.println(countCommas(n1));

        int n2 = 998;
        System.out.println(countCommas(n2));
    }
}
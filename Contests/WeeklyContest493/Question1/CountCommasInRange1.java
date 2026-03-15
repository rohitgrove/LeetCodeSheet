public class CountCommasInRange1 {
    public static int countCommas(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int digits = String.valueOf(i).length();
            if (digits >= 4) {
                count += (digits - 1) / 3;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n1 = 1002;
        System.out.println(countCommas(n1));

        int n2 = 998;
        System.out.println(countCommas(n2));
    }
}
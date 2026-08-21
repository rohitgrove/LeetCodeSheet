public class Pattern1 {
    public static void main(String[] args) {
        int n = 5;
        int row = 0;
        int tot_st = n;

        while (row <= n) {
            int cnt_st = 0;
            while (cnt_st < tot_st) {
                System.out.print("* ");
                cnt_st++;
            }
            System.out.println();
            row++;
        }
    }
}

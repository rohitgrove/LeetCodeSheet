public class Pattern18 {
    public static void main(String[] args) {
        int n = 7;
        int row = 1;
        int tot_st = 1;
        int tot_sp = n - 1;

        while (row <= n) {
            int cnt_sp = 0;
            while (cnt_sp < tot_sp) {
                System.out.print("  ");
                cnt_sp++;
            }

            int cnt_st = 0;
            while (cnt_st < tot_st) {
                System.out.print(" *");
                cnt_st++;
            }
            System.out.println();

            if (row <= (n / 2)) {
                tot_sp--;
                tot_st += 2;
            } else {
                tot_sp++;
                tot_st -= 2;
            }
            row++;
        }
    }
}

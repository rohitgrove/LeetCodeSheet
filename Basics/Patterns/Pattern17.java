public class Pattern17 {
    public static void main(String[] args) {
        int n = 7;
        int row = 0;

        int first_tot_st = n / 3;
        int tot_sp = 1;
        int second_tot_st = n / 3;
        while (row < n) {
            int cnt_st_first = 0;
            while (cnt_st_first <= first_tot_st) {
                System.out.print("* ");
                cnt_st_first++;
            }

            int cnt_sp = 0;
            while (cnt_sp < tot_sp) {
                System.out.print("  ");
                cnt_sp++;
            }

            int cnt_st_second = 0;
            while (cnt_st_second <= second_tot_st) {
                System.out.print(" *");
                cnt_st_second++;
            }

            System.out.println();

            if (row <= n / 3) {
                first_tot_st--;
                tot_sp += 2;
                second_tot_st--;
            } else {
                first_tot_st++;
                tot_sp -= 2;
                second_tot_st++;
            }

            row++;
        }
    }
}

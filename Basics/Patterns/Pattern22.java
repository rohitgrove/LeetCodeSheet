public class Pattern22 {
    public static void main(String[] args) {
        int n = 5;
        int row = 1;
        int tots_st = n;
        int tots_sp = 0;
        while (row <= n) {
            int cnt_st = 1;
            while (cnt_st <= tots_st) {
                System.out.print("* ");
                cnt_st++;
            }

            int cnt_sp = 1;
            while (cnt_sp < tots_sp) {
                System.out.print("  ");
                cnt_sp++;
            }

            int cnt_st2 = 0;
            while (cnt_st2 < tots_st) {
                System.out.print("* ");
                cnt_st2++;
                if (cnt_st2 == n - 1) {
                    // tots_st++;
                    cnt_st2 = n;
                }
            }

            System.out.println();
            row++;
            tots_st--;
            tots_sp = tots_sp + 2;
        }
    }
}

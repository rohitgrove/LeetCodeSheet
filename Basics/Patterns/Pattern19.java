public class Pattern19 {
    public static void main(String[] args) {
        int n = 7;
        int row = 1;
        int tots_sp = 1;
        int tots_st = n / 2;
        while (row <= n) {
            int cnt_st = 1;
            while (cnt_st <= tots_st + 1) {
                System.out.print("* ");
                cnt_st++;
            }

            int cnt_sp = 1;
            while (cnt_sp < tots_sp) {
                System.out.print("  ");
                cnt_sp++;
            }

            cnt_st = 0;
            while (cnt_st <= tots_st) {
                System.out.print("* ");
                cnt_st++;
            }

            System.out.println();
            if (row < (n / 2 + 1)) {
                tots_sp = tots_sp + 2;
                tots_st = tots_st - 1;
            } else {
                tots_sp = tots_sp - 2;
                tots_st = tots_st + 1;
            }
            row++;
        }
    }
}

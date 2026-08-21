public class Pattern25 {
    public static void main(String[] args) {
        int n = 5;
        int row = 1;
        int tots_sp = n - 1;
        int tots_st = 1;
        int num = 1;
        while (row <= n) {
            int cnt_sp = 0;
            while (cnt_sp < tots_sp) {
                System.out.print("  ");
                cnt_sp++;
            }

            int cnt_st = 0;
            while (cnt_st < tots_st) {
                System.out.print(num + " ");
                num++;
                cnt_st++;
            }
            System.out.println();
            tots_st = tots_st + 2;
            tots_sp--;
            row++;
        }
    }
}

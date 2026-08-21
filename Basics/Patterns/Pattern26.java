public class Pattern26 {
    public static void main(String[] args) {
        int n = 5;
        int row = 1;
        int tots_sp = n - 1;
        int tots_num = 1;
        while (row <= n) {
            int cnt_sp = 0;
            while (cnt_sp < tots_sp) {
                System.out.print("  ");
                cnt_sp++;
            }

            int cnt_st = 0;
            int num = 1;
            while (cnt_st < tots_num) {
                System.out.print(num + " ");
                cnt_st++;
                num++;
            }
            System.out.println();
            tots_num = tots_num + 2;
            tots_sp--;
            row++;
        }
    }
}
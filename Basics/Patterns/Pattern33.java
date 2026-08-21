public class Pattern33 {
    public static void main(String[] args) {
        int n = 10;
        int row = 1;
        int tots_sp = n - 1;
        int tots_num = 1;
        int num = 10;
        while (row <= n) {
            int cnt_sp = 0;
            while (cnt_sp < tots_sp) {
                System.out.print("  ");
                cnt_sp++;
            }

            int cnt_num = 0;
            int i = num;
            while (cnt_num < tots_num) {
                if (i == 10) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print(i + " ");
                }
                if (cnt_num < tots_num / 2) {
                    i++;
                } else {
                    i--;
                }
                cnt_num++;
            }
            System.out.println();
            tots_sp = tots_sp - 1;
            tots_num = tots_num + 2;
            row++;
            num--;
        }
    }
}
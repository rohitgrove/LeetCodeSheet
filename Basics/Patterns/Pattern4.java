public class Pattern4 {
    public static void main(String[] args) {
        int n = 5;
        int row = 1;
        int total_sp = n - 1;
        int total_st = 1;

        while (row <= n) {
            int cnt_sp = 0;
            while (cnt_sp < total_sp) {
                System.out.print("  ");
                cnt_sp++;
            }

            int cnt_st = 0;
            while (cnt_st < total_st) {
                System.out.print(" *");
                cnt_st++;
            }

            System.out.println();
            total_sp--;
            total_st++;
            row++;
        }
    }
}

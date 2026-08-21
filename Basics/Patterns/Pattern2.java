public class Pattern2 {
    public static void main(String[] args) {
        int n = 5;
        int row = 1;
        int tot_st = 1;

        while (row <= n) {
            int cnt_st = 0;
            while (cnt_st < tot_st) {
                System.out.print("* ");
                cnt_st++;
            }
            System.out.println();
            tot_st++;
            row++;
        }
    }
}
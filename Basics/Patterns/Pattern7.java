public class Pattern7 {
    public static void main(String[] args) {
        int n = 5;
        int row = 1;
        int tot_st = n;

        while (row <= n) {
            int cnt_st = 1;
            while (cnt_st <= tot_st) {
                if (row == 1 || row == n || cnt_st == 1 || cnt_st == tot_st) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
                cnt_st++;
            }
            System.out.println();
            row++;
        }
    }
}

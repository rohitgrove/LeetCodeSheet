public class Pattern15 {
    public static void main(String[] args) {
        int n = 5;
        int row = 1;
        int tot_st = n;
        int tot_sp = 0;
        int end = (n * 2) - 1;

        while (row <= end) {
            int cnt_sp = 0;
            while (cnt_sp < tot_sp) {
                System.out.print("  ");
                cnt_sp++;
            }

            int cnt_st = 0;
            while (cnt_st < tot_st) {
                System.out.print("* ");
                cnt_st++;
            }
            System.out.println();

            if (row < n) {
                tot_st--;
                tot_sp += 2;
            } else {
                tot_sp -= 2;
                tot_st++;
            }
            row++;
        }
    }
}

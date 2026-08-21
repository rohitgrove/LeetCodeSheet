public class Pattern13 {
    public static void main(String[] args) {
        int n = 5;
        int row = 1;
        int end = (n * 2) - 1;

        int tot_st = 1;
        while (row <= end) {
            int cnt_st = 0;
            while (cnt_st < tot_st) {
                System.out.print("* ");
                cnt_st++;
            }
            System.out.println();
            if (row < n) {
                tot_st++;
            } else {
                tot_st--;
            }
            row++;
        }
    }
}

public class Pattern30 {
    public static void main(String[] args) {
        int n = 5;
        int row = 1;
        while (row <= n) {
            int cnt_st = 0;
            int num = 5;
            while (cnt_st < n) {
                System.out.print(num + " ");
                cnt_st++;
                num--;
            }
            System.out.println();
            row++;
        }
    }
}

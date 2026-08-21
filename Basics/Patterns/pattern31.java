public class pattern31 {
    public static void main(String[] args) {
        int n = 5;
        int row = 1;
        int star = row;
        while (row <= n) {
            int cnt_st = 1;
            int num = 5;
            while (cnt_st <= n) {
                if (num == star) {
                    System.out.print("* ");
                } else {
                    System.out.print(num + " ");
                }
                cnt_st++;
                num--;
            }
            System.out.println();
            star++;
            row++;
        }
    }
}

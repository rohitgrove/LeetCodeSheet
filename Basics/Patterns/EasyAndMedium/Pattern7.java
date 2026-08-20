public class Pattern7 {
    public static void main(String[] args) {
        int n = 5;
        int start_Row = 0;
        int end_Row = n;
        int end_sp = n;
        int end_st = 1;
        while (start_Row < end_Row) {
            int cnt_sp = 0;
            while (cnt_sp < end_sp) {
                System.out.print("   ");
                cnt_sp++;
            }

            int cnt_st = 0;
            while (cnt_st < end_st) {
                System.out.print(" * ");
                cnt_st++;
            }
            System.out.println();
            end_st += 2;
            end_sp--;
            start_Row++;
        }
    }
}

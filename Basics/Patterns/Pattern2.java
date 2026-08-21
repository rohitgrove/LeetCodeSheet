public class Pattern2 {
    public static void main(String[] args) {
        int n = 5;
        int start_Row = 1;
        int end_Row = n;

        while (start_Row <= end_Row) {
            int start_Col = 0;
            int end_Col = start_Row;
            while (start_Col < end_Col) {
                System.out.print("* ");
                start_Col++;
            }
            System.out.println();
            start_Row++;
        }
    }
}

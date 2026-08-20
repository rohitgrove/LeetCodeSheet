public class Pattern6 {
    public static void main(String[] args) {
        int n = 5;
        int start_Row = 0;
        int end_Row = n;

        while (start_Row < end_Row) {
            int start_Col = 0;
            int end_col = n - start_Row;
            int count = 1;
            while (start_Col < end_col) {
                System.out.print(count + " ");
                count++;
                start_Col++;
            }
            System.out.println();
            start_Row++;
        }
    }
}

public class Pattern1 {
    public static void main(String[] args) {
        int n = 5;
        int start_Row = 0;
        int end_Row = n;
        int start_Col;
        int end_Col = n;

        while (start_Row < end_Row) {
            start_Col = 0;
            while (start_Col < end_Col) {
                System.out.print("* ");
                start_Col++;
            }
            System.out.println();
            start_Row++;
        }
    }
}

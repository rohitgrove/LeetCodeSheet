public class PrintNNumbersTo1 {
    public static void printNumbers(int counter, int n) {
        if (counter > n) {
            return;
        }

        printNumbers(counter + 1, n);
        System.out.println(counter);
    }

    public static void main(String[] args) {
        printNumbers(1, 5);
    }
}

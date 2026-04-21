public class PrintNNumbersToOne {
    public static void printNumbers(int current, int N) {
        if (current > N) {
            return;
        }

        printNumbers(current + 1, N);
        System.out.print(current + " ");
    }

    public static void main(String[] args) {
        printNumbers(1, 10);
    }
}

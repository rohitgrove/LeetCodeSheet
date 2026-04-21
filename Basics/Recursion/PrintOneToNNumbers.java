public class PrintOneToNNumbers {
    public static void printNumbers(int current, int N) {
        if (current > N) {
            return;
        }

        System.out.print(current + " ");
        printNumbers(current + 1, N);
    }

    public static void main(String[] args) {
        printNumbers(1, 10);
    }
}

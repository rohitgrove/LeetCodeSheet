public class Print1ToNNumbers {
    public static void printNumbers(int counter, int n) {
        if (counter > n) {
            return;
        }

        System.out.println(counter);
        printNumbers(counter + 1, n);
    }

    public static void main(String[] args) {
        printNumbers(1, 5);
    }
}

public class PrintNNamesUsingRecursion {
    public static void printName(String name, int count, int N) {
        if (count == N) {
            return;
        }

        System.out.println("Rohit");
        printName(name, count + 1, N);
    }

    public static void main(String[] args) {
        printName("Rohit", 0, 5);
    }
}

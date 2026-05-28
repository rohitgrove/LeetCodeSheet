public class PrintNameNTimes {
    public static void printName(int count, int n, String name) {
        if (count > n) {
            return;
        }

        System.out.println(count + ". " + name);
        printName(count + 1, n, name);
    }

    public static void main(String[] args) {
        printName(1, 5, "Rohit");
    }
}

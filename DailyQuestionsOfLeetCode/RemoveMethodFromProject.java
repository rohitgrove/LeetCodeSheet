import java.util.List;

public class RemoveMethodFromProject {
    public static List<Integer> remainingMethods(int n, int k, int[][] invocations) {

    }

    public static void main(String[] args) {
        int invocations1[][] = { { 1, 2 },
                { 0, 1 },
                { 3, 2 } };
        System.out.println(remainingMethods(4, 1, invocations1));
        int invocations2[][] = { { 1, 2 },
                { 0, 2 },
                { 0, 1 },
                { 3, 4 } };
        System.out.println(remainingMethods(5, 0, invocations2));
        int invocations3[][] = { { 1, 2 },
                { 0, 1 },
                { 2, 0 } };
        System.out.println(remainingMethods(3, 2, invocations3));
    }
}

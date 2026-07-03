import java.util.Arrays;

public class BoatsToSavePeople {
    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int boat = 0;
        int start = 0;
        int end = people.length - 1;

        while (start < end) {
            if (people[start] + people[end] <= limit) {
                boat++;
                end--;
                start++;
            } else {
                boat++;
                end--;
            }
        }

        if (start == end) {
            boat++;
        }
        return boat;
    }

    public static void main(String[] args) {
        int people1[] = { 1, 2 };
        System.out.println(numRescueBoats(people1, 3));
        int people2[] = { 3, 2, 2, 1 };
        System.out.println(numRescueBoats(people2, 3));
        int people3[] = { 3, 5, 3, 4 };
        System.out.println(numRescueBoats(people3, 5));
        int people4[] = { 8, 1, 7, 6, 2, 4 };
        System.out.println(numRescueBoats(people4, 8));
    }
}

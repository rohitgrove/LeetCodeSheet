import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CinemaSeatAllocation {
    public static int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        // row -> reserved seats ka set
        HashMap<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            map.putIfAbsent(row, new HashSet<>());
            map.get(row).add(col);
        }

        // Jitni rows mein reservation nahi hai,
        // har such row mein 2 groups aa sakte hain.
        int reservedRows = map.size();
        long ans = 2L * (n - reservedRows);

        // Sirf reserved rows ko check karo
        for (Set<Integer> seats : map.values()) {
            boolean left = true; // 2,3,4,5
            boolean middle = true; // 4,5,6,7
            boolean right = true; // 6,7,8,9

            // Left block
            for (int i = 2; i <= 5; i++) {
                if (seats.contains(i)) {
                    left = false;
                    break;
                }
            }

            // Middle block
            for (int i = 4; i <= 7; i++) {
                if (seats.contains(i)) {
                    middle = false;
                    break;
                }
            }

            // Right block
            for (int i = 6; i <= 9; i++) {
                if (seats.contains(i)) {
                    right = false;
                    break;
                }
            }

            // Left + Right dono non-overlapping hain
            if (left && right) {
                ans += 2;
            }
            // Agar koi bhi ek block available hai
            else if (left || middle || right) {
                ans += 1;
            }
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        int reservedSeats1[][] = { { 1, 2 },
                { 1, 3 },
                { 1, 8 },
                { 2, 6 },
                { 3, 1 },
                { 3, 10 } };
        System.out.println(maxNumberOfFamilies(3, reservedSeats1));
        int reservedSeats2[][] = { { 2, 1 },
                { 1, 8 },
                { 2, 6 } };
        System.out.println(maxNumberOfFamilies(2, reservedSeats2));
        int reservedSeats3[][] = { { 4, 3 },
                { 1, 4 },
                { 4, 6 },
                { 1, 7 } };
        System.out.println(maxNumberOfFamilies(4, reservedSeats3));
    }
}

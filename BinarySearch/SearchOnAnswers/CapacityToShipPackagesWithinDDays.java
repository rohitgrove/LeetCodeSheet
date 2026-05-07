public class CapacityToShipPackagesWithinDDays {
    public static boolean isPossible(int[] weights, int weight, int days) {
        int totaWeight = 0;
        int day = 1;

        for (int i = 0; i < weights.length; i++) {
            if (totaWeight + weights[i] <= weight) {
                totaWeight += weights[i];
            } else {
                day++;
                totaWeight = weights[i];
            }
        }

        return day <= days;
    }

    public static int shipWithinDays(int[] weights, int days) {
        int s = 0;
        int e = 0;

        for (int i = 0; i < weights.length; i++) {
            e += weights[i];
            s = Math.max(s, weights[i]);
        }
        if (days == 1) {
            return e;
        }
        int ans = -1;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (isPossible(weights, mid, days)) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int weights1[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println(shipWithinDays(weights1, 5));
        int weights2[] = { 3, 2, 2, 4, 1, 4 };
        System.out.println(shipWithinDays(weights2, 3));
        int weights3[] = { 1, 2, 3, 1, 1 };
        System.out.println(shipWithinDays(weights3, 4));
    }
}

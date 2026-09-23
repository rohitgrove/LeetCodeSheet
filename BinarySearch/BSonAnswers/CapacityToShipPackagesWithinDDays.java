public class CapacityToShipPackagesWithinDDays {
    public static int shipWithinDays(int[] weights, int days) {
        int start = 0;
        int end = 0;

        for (int i = 0; i < weights.length; i++) {
            end += weights[i];
        }

        int mid = start + (end - start) / 2;
        int ans = -1;
        while (start <= end) {
            if (isPossible(weights, mid, days)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            mid = start + (end - start) / 2;
        }

        return ans;
    }

    public static boolean isPossible(int[] weights, int mid, int days) {
        int count = 0;
        int shipDays = 1;

        for (int i = 0; i < weights.length; i++) {
            if (count + weights[i] <= mid) {
                count += weights[i];
            } else {
                shipDays++;
                if (shipDays > days || weights[i] > mid) {
                    return false;
                }
                count = 0;
                count += weights[i];
            }
        }

        return true;
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

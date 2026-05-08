public class MinimizeMaxDistanceToGasStation {
    public static boolean canPlace(int[] stations, int k, double dist) {
        int required = 0;

        for (int i = 0; i < stations.length - 1; i++) {
            double gap = stations[i + 1] - stations[i];

            // Number of stations needed
            required += (int)(gap / dist);

            // Exact divisible case
            if (gap % dist == 0) {
                required--;
            }
        }

        return required <= k;
    }

    public static double minMaxDist(int[] stations, int k) {
        int n = stations.length;

        double low = 0;
        double high = 0;

        // Find maximum existing gap
        for (int i = 0; i < n - 1; i++) {
            high = Math.max(high, stations[i + 1] - stations[i]);
        }

        // Binary Search on answer
        while (high - low > 1e-6) {

            double mid = low + (high - low) / 2.0;

            if (canPlace(stations, k, mid)) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return high;
    }

    public static void main(String[] args) {
        int stations1[] = { 1, 2, 3, 4, 5 };
        System.out.println(minMaxDist(stations1, 2));
        int stations2[] = { 3, 6, 12, 19, 33 };
        System.out.println(minMaxDist(stations2, 3));
    }
}

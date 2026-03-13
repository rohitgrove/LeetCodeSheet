public class MinimumNumberOfSecondsToMakeMountainHeightZero {
    public static boolean canReduceMountain(int mountainHeight, int[] workerTimes, long maxTime) {
        long totalReduction = 0;

        for (int time : workerTimes) {
            long low = 1, high = mountainHeight;

            while (low <= high) {
                long mid = (low + high) / 2;
                long cost = (mid * (mid + 1)) / 2 * time;

                if (cost <= maxTime) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            totalReduction += high;
            if (totalReduction >= mountainHeight) {
                return true;
            }
        }

        return totalReduction >= mountainHeight;
    }

    public static long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long low = 1, high = (long) 1e18, result = high;

        while (low <= high) {
            long mid = (low + high) / 2;

            if (canReduceMountain(mountainHeight, workerTimes, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int workerTimes1[] = { 2, 1, 1 };
        System.out.println(minNumberOfSeconds(4, workerTimes1));
        int workerTimes2[] = { 3, 2, 2, 4 };
        System.out.println(minNumberOfSeconds(10, workerTimes2));
        int workerTimes3[] = { 1 };
        System.out.println(minNumberOfSeconds(5, workerTimes3));
    }
}

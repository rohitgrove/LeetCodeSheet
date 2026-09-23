public class MinimumNumberOfDaysToMakeMBouquets {
    public static int minDays(int[] bloomDay, int m, int k) {
        int l = 1, r = 1000000000;
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int consecutiveLength = 0, bouquets = 0;
            for (int i = 0; i < bloomDay.length; i++) {
                if (bloomDay[i] <= mid) {
                    consecutiveLength++;
                    if (consecutiveLength >= k) {
                        consecutiveLength = 0;
                        bouquets++;
                    }
                } else {
                    consecutiveLength = 0;
                }
            }
            if (bouquets >= m) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int bloomDay1[] = { 1, 10, 3, 10, 2 };
        System.out.println(minDays(bloomDay1, 3, 1));
        System.out.println(minDays(bloomDay1, 3, 2));
        int bloomDay2[] = { 7, 7, 7, 7, 12, 7, 7 };
        System.out.println(minDays(bloomDay2, 2, 3));
    }
}

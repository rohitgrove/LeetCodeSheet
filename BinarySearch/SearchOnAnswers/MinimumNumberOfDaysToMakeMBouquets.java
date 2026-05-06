public class MinimumNumberOfDaysToMakeMBouquets {
    public static boolean canMake(int[] bloomDay, int day, int m, int k) {
        int banquet = 0;
        int count = 0;

        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                count++;
                if (count == k) {
                    banquet++;
                    count = 0;
                }
            } else {
                count = 0;
            }
        }

        return banquet >= m;
    }

    public static int minDays(int[] bloomDay, int m, int k) {
        if ((m * k) > bloomDay.length) {
            return -1;
        }

        int s = Integer.MAX_VALUE;
        int e = Integer.MIN_VALUE;

        for (int i = 0; i < bloomDay.length; i++) {
            s = Math.min(bloomDay[i], s);
            e = Math.max(bloomDay[i], e);
        }

        int mid = s + (e - s) / 2;
        int ans = -1;
        while (s <= e) {
            if (canMake(bloomDay, mid, m, k)) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
            mid = s + (e - s) / 2;
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

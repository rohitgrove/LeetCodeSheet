public class KokoEatingBannana {
    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) {
            right = Math.max(right, piles[i]);
        }

        int mid = left + (right - left) / 2;

        while (left < right) {
            if (canFinishInTime(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
            mid = left + (right - left) / 2;
        }

        return left;
    }

    public static boolean canFinishInTime(int piles[], int speed, int h) {
        int totalSpeed = 0;

        for (int i = 0; i < piles.length; i++) {
            totalSpeed += (piles[i] + speed - 1) / speed;
        }

        return totalSpeed <= h;
    }

    public static void main(String[] args) {
        int piles1[] = { 3, 6, 7, 11 }, h1 = 8;
        System.out.println(minEatingSpeed(piles1, h1));
        int piles2[] = { 30, 11, 23, 4, 20 }, h2 = 5;
        System.out.println(minEatingSpeed(piles2, h2));
        int piles3[] = { 30, 11, 23, 4, 20 }, h3 = 6;
        System.out.println(minEatingSpeed(piles3, h3));
    }
}

public class PaintersPartition {
    public static boolean isPossible(int[] boards, int mid, int k) {
        int painterCount = 1;
        int board = 0;
        for (int i = 0; i < boards.length; i++) {
            if (board + boards[i] <= mid) {
                board += boards[i];
            } else {
                painterCount++;
                if (painterCount > k || boards[i] > mid) {
                    return false;
                }
                board = 0;
                board += boards[i];
            }
        }

        return true;
    }

    public static int findLargestMinDistance(int boards[], int k) {
        if (k > boards.length) {
            return -1;
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < boards.length; i++) {
            end += boards[i];
        }

        int ans = -1;
        int mid = start + (end - start) / 2;
        while (start <= end) {
            if (isPossible(boards, mid, k)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            mid = start + (end - start) / 2;
        }

        return ans;
    }

    public static void main(String[] args) {
        int boards[] = { 10, 20, 30, 40 };
        System.out.println(findLargestMinDistance(boards, 2));
    }
}

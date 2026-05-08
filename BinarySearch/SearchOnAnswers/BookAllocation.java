public class BookAllocation {
    public static boolean isPossible(int[] arr, int mid, int k) {
        int studentCount = 1;
        int pageSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (pageSum + arr[i] <= mid) {
                pageSum += arr[i];
            } else {
                studentCount++;
                if (studentCount > k || arr[i] > mid) {
                    return false;
                }
                pageSum = 0;
                pageSum += arr[i];
            }
        }

        return true;
    }

    public static int findPages(int[] arr, int k) {
        if (k > arr.length) {
            return -1;
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < arr.length; i++) {
            end += arr[i];
        }

        int ans = -1;
        int mid = start + (end - start) / 2;
        while (start <= end) {
            if (isPossible(arr, mid, k)) {
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
        int arr[] = { 12, 34, 67, 90 }, k = 2;
        System.out.println(findPages(arr, k));
    }
}

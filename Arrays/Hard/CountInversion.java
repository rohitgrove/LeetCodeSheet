public class CountInversion {
    public static int bruteForce(int nums[]) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public static int mergeSort(int nums[], int temp[], int start, int end) {
        if (start >= end) {
            return 0;
        }

        int mid = start + (end - start) / 2;
        int cnt = 0;

        cnt += mergeSort(nums, temp, start, mid);
        cnt += mergeSort(nums, temp, mid + 1, end);
        cnt += merge(nums, temp, start, mid, end);
        return cnt;
    }

    public static int merge(int[] nums, int[] temp, int start, int mid, int end) {
        int s = start;
        int e = mid + 1;
        int k = start;
        int cnt = 0;

        while (s <= mid && e <= end) {
            if (nums[s] <= nums[e]) {
                temp[k] = nums[s];
                s++;
            } else {
                temp[k] = nums[e];
                cnt += (mid - s + 1);
                e++;
            }
            k++;
        }

        while (s <= mid) {
            temp[k] = nums[s];
            s++;
            k++;
        }

        while (e <= end) {
            temp[k] = nums[e];
            e++;
            k++;
        }

        for (int l = start; l <= end; l++) {
            nums[l] = temp[l];
        }

        return cnt;
    }

    public static int inversionCount(int nums[]) {
        int start = 0;
        int end = nums.length - 1;
        int temp[] = new int[nums.length];
        return mergeSort(nums, temp, start, end);
    }

    public static void main(String[] args) {
        int nums1[] = { 2, 4, 1, 3, 5 };
        System.out.println(inversionCount(nums1)); // 3
        int nums2[] = { 5, 4, 3, 2, 1 };
        System.out.println(inversionCount(nums2)); // 10
        int nums3[] = { 5, 3, 2, 1, 4 };
        System.out.println(inversionCount(nums3)); // 7
    }
}

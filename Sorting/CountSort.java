public class CountSort {
    public static void countSort(int[] nums) {
        int largestNum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            largestNum = Math.max(nums[i], largestNum);
        }

        int count[] = new int[largestNum + 1];

        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        int idx = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                nums[idx] = i;
                idx++;
                count[i]--;
            }
        }
    }

    public static void printArr(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums1[] = { 5, 4, 3, 2, 1 };
        countSort(nums1);
        printArr(nums1);
        int nums2[] = { 10, 1, 7, 6, 14, 9 };
        countSort(nums2);
        printArr(nums2);
        int nums3[] = { 34, 8, 64, 51, 32, 21 };
        countSort(nums3);
        printArr(nums3);
        int nums4[] = { 44, 33, 55, 22, 11 };
        countSort(nums4);
        printArr(nums4);
        int nums5[] = { 34, 8, 64, 51, 32, 21 };
        countSort(nums5);
        printArr(nums5);
    }
}

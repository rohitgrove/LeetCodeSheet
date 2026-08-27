public class SortColors {
    public static void firstApproach(int nums[]) {
        int count[] = new int[3];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        int idx = 0;
        while (count[0] != 0) {
            nums[idx] = 0;
            idx++;
            count[0]--;
        }

        while (count[1] != 0) {
            nums[idx] = 1;
            idx++;
            count[1]--;
        }

        while (count[2] != 0) {
            nums[idx] = 2;
            idx++;
            count[2]--;
        }
    }

    public static void secondApproach(int nums[]) {
        int left = 0;
        int index = 0;
        int right = nums.length - 1;

        while (index <= right) {
            if (nums[index] == 0) {
                int temp = nums[index];
                nums[index] = nums[left];
                nums[left] = temp;
                index++;
                left++;
            } else if (nums[index] == 2) {
                int temp = nums[index];
                nums[index] = nums[right];
                nums[right] = temp;
                right--;
            } else {
                index++;
            }
        }
    }

    public static void sortColors(int[] nums) {
        secondApproach(nums);
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums1[] = { 2, 0, 2, 1, 1, 0 };
        sortColors(nums1);
        printArr(nums1);
        int nums2[] = { 2, 0, 1 };
        sortColors(nums2);
        printArr(nums2);
    }
}

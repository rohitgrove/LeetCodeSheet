public class Sort012 {
    public static void bruteForce(int[] nums) {
        int hash[] = new int[3];

        for (int i = 0; i < nums.length; i++) {
            hash[nums[i]]++;
        }

        int j = 0;
        for (int i = 0; i < hash.length; i++) {
            while (hash[i] != 0) {
                nums[j] = i;
                j++;
                hash[i]--;
            }
        }
    }

    public static void optimizedApproach(int[] nums) {
        int start = 0;
        int index = 0;
        int end = nums.length - 1;

        while (index <= end) {
            if (nums[index] == 0) {
                int temp = nums[start];
                nums[start] = nums[index];
                nums[index] = temp;
                start++;
                index++;
            } else if (nums[index] == 2) {
                int temp = nums[end];
                nums[end] = nums[index];
                nums[index] = temp;
                end--;
            } else {
                index++;
            }
        }
    }

    public static void sortColors(int[] nums) {
        optimizedApproach(nums);
    }

    public static void printArr(int nums[]) {
        for (int ele : nums) {
            System.out.print(ele + " ");
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

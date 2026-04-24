import java.util.Arrays;

public class MissingNumber {
    public static int missingNumberBruteForce(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }

        return nums.length;
    }

    public static int missingNumberOptimized(int[] nums) {
        int hash[] = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            hash[nums[i]]++;
        }

        for (int i = 0; i < hash.length; i++) {
            if (hash[i] == 0) {
                return i;
            }
        }

        return -1;
    }

    public static int missingNumberMoreOptimized(int[] nums) {
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i];
        }

        for (int i = 0; i <= nums.length; i++) {
            ans ^= i;
        }

        return ans;
    }

    public static int missingNumber(int[] nums) {
        return missingNumberMoreOptimized(nums);
    }

    public static void main(String[] args) {
        int nums1[] = { 3, 0, 1 };
        System.out.println(missingNumber(nums1));
        int nums2[] = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
        System.out.println(missingNumber(nums2));
        int nums3[] = { 0, 1 };
        System.out.println(missingNumber(nums3));
    }
}
public class CheckIfArrayIsSortedAndRotated {
    public static boolean check(int[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                cnt++;
            }
        }

        if (nums[0] < nums[nums.length - 1]) {
            cnt++;
        }

        return cnt <= 1;
    }

    public static void main(String[] args) {
        int nums1[] = { 3, 4, 5, 1, 2 };
        System.out.println(check(nums1));
        int nums2[] = { 2, 1, 3, 4 };
        System.out.println(check(nums2));
        int nums3[] = { 1, 2, 3 };
        System.out.println(check(nums3));
    }
}

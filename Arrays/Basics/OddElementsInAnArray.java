public class OddElementsInAnArray {
    public static int oddElements(int nums[]) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int nums1[] = { 2, 5, 8, 11, 14 };
        System.out.println(oddElements(nums1));
        int nums2[] = { 2, 4, 6, 8 };
        System.out.println(oddElements(nums2));
    }
}

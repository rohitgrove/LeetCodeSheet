public class SumOfArrayElements {
    public static int sumOfArr(int nums[]) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 2, 3, 4, 5 };
        System.out.println(sumOfArr(nums1));
        int nums2[] = { 4, -2, 0, 7, -3 };
        System.out.println(sumOfArr(nums2));
    }
}

public class TransformedArray {
    public static int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {

            // If value is 0, directly assign
            if (nums[i] == 0) {
                result[i] = 0;
                continue;
            }

            // Calculate new index using circular logic
            int newIndex = (i + nums[i]) % n;

            // Handle negative index
            if (newIndex < 0) {
                newIndex += n;
            }

            result[i] = nums[newIndex];
        }

        return result;
    }

    public static void printArr(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums1[] = { 3, -2, 1, 1 };
        printArr(constructTransformedArray(nums1));
        int nums2[] = { -1, 4, -1 };
        printArr(constructTransformedArray(nums2));
    }
}

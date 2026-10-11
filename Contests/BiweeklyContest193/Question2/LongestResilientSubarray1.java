public class LongestResilientSubarray1 {
    public static int resilientSubarray(int[] nums, int k) {
        int n = nums.length;
        int maxLen = 0;
        int i = 0;

        while (i < n) {
            int remainder = nums[i] % k;
            int j = i;
            while (j < n && nums[j] % k == remainder) {
                j++;
            }

            int len = j - i;
            int period = k / gcd(remainder, k);
            int validLen = 1 + ((len - 1) / period) * period;
            maxLen = Math.max(maxLen, validLen);
            i = j;
        }

        return maxLen;
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] nums1 = { 2, 4, 6 };
        int k1 = 2;
        System.out.println(resilientSubarray(nums1, k1));

        int[] nums2 = { 1, 4, 7, 1 };
        int k2 = 3;
        System.out.println(resilientSubarray(nums2, k2));

        int[] nums3 = { 5, 5, 4, 8 };
        int k3 = 4;
        System.out.println(resilientSubarray(nums3, k3));
    }
}

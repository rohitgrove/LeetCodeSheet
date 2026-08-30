public class SumOfDecodedNumbers {
    public static long power(long num1, long num2, long mod) {
        long result = 1;
        num1 %= mod;

        while (num2 > 0) {
            if ((num2 & 1) == 1) {
                result = (result * num1) % mod;
            }

            num1 = (num1 * num1) % mod;
            num2 >>= 1;
        }

        return result;
    }

    public static int sumDecoded(long[] nums) {
        long MOD = 1000000007L;
        long ans = 0;

        for (int i = 0; i < nums.length; i++) {
            long num = nums[i];
            int width = (int) (num % 10);
            long rem = num / 10;

            String remString = Long.toString(rem);

            long num1 = Long.parseLong(remString.substring(0, width));
            long num2 = Long.parseLong(remString.substring(width));

            ans = (ans + power(num1, num2, MOD)) % MOD;
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        long[] nums1 = { 231 };
        System.out.println(sumDecoded(nums1));

        long[] nums2 = { 2522, 2101 };
        System.out.println(sumDecoded(nums2));

        long[] nums3 = { 2301 };
        System.out.println(sumDecoded(nums3));
    }
}

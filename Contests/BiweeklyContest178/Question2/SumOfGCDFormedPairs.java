import java.util.Arrays;

public class SumOfGCDFormedPairs {
    public static long gcd(long a, long b){
        while(b != 0){
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    public static long sumOfGcdPairs(int[] nums){
        int n = nums.length;

        long[] prefixGcd = new long[n];
        int mx = nums[0];

        for(int i = 0; i < n; i++){
            mx = Math.max(mx, nums[i]);
            prefixGcd[i] = gcd(nums[i], mx);
        }

        Arrays.sort(prefixGcd);

        int l = 0, r = n - 1;
        long sum = 0;

        while(l < r){
            sum += gcd(prefixGcd[l], prefixGcd[r]);
            l++;
            r--;
        }

        return sum;
    }

    public static void main(String[] args) {

        int[] nums1 = { 2, 6, 4 };
        System.out.println(sumOfGcdPairs(nums1));

        int[] nums2 = { 3, 6, 2, 8 };
        System.out.println(sumOfGcdPairs(nums2));

    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestSubarrayWithAtMostKDistinctPrime {
    public static int[] getFactors(int num, int[] spf) {
        int[] temp = new int[10];
        int count = 0;

        while (num > 1) {
            int prime = spf[num];
            temp[count++] = prime;

            while (num % prime == 0) {
                num /= prime;
            }
        }

        return Arrays.copyOf(temp, count);
    }

    public static int longestSubarray(int[] nums, int k) {
        int max = 0;

        for (int idx = 0; idx < nums.length; idx++) {
            if (max <= nums[idx]) {
                max = nums[idx];
            }
        }

        int[] spf = new int[max + 1];

        for (int idx = 0; idx <= max; idx++) {
            spf[idx] = idx;
        }

        for (int i = 2; i * i <= max; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j <= max; j += i) {
                    if (spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }

        List<int[]> factors = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            factors.add(getFactors(nums[i], spf));
        }

        int[] freq = new int[max + 1];

        int dist = 0;
        int left = 0;
        int ans = 0;

        for (int right = 0; right < nums.length; right++) {
            for (int prime : factors.get(right)) {
                if (freq[prime] == 0) {
                    dist++;
                }

                freq[prime]++;
            }

            while (dist > k) {
                for (int prime : factors.get(left)) {
                    freq[prime]--;

                    if (freq[prime] == 0) {
                        dist--;
                    }
                }

                left++;
            }

            int diff = right - left + 1;
            if (ans <= diff) {
                ans = diff;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int nums1[] = { 7, 6, 10, 12, 11 };
        System.out.println(longestSubarray(nums1, 3));
        int nums2[] = { 4, 6, 9, 18 };
        System.out.println(longestSubarray(nums2, 4));
        int nums3[] = { 6, 10, 15 };
        System.out.println(longestSubarray(nums3, 2));
    }
}

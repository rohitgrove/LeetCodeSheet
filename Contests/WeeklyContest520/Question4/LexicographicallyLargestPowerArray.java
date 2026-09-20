import java.util.Arrays;

public class LexicographicallyLargestPowerArray {
    public static int[] largestPower(int[] nums) {
        int n = nums.length;
        int size = 1 << 15;

        int[] freq = new int[size];

        for (int x : nums) {
            freq[x]++;
        }

        int active = size - 1;
        int[] ans = new int[15];
        int pos = 0;

        while (pos < n && active != 0) {
            int batch = 0;

            for (int mask = 0; mask < size; mask++) {
                if (freq[mask] > 0 && (mask & active) == active) {
                    batch += freq[mask];
                }
            }

            if (batch > 0) {
                for (int mask = 0; mask < size; mask++) {
                    if (freq[mask] > 0 && (mask & active) == active) {
                        freq[mask] = 0;
                    }
                }

                pos += batch;

                if (pos == n) {
                    break;
                }
            }

            int best = -1;
            int bestProjection = -1;

            for (int mask = 0; mask < size; mask++) {
                if (freq[mask] > 0) {
                    int projection = mask & active;

                    if (projection > bestProjection) {
                        bestProjection = projection;
                        best = mask;
                    }
                }
            }

            if (best == -1) {
                break;
            }

            int zeroBits = active & ~best;

            for (int bit = 0; bit < 15; bit++) {
                if ((zeroBits & (1 << bit)) != 0) {
                    ans[14 - bit] = pos;
                }
            }

            active &= best;
            freq[best]--;
            pos++;
        }

        for (int bit = 0; bit < 15; bit++) {
            if ((active & (1 << bit)) != 0) {
                ans[14 - bit] = n;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = { 7, 5 };
        int[] nums2 = { 3, 1, 7 };
        int[] nums3 = { 0 };
        int[] nums4 = { 32767 };
        int[] nums5 = { 1, 4 };
        int[] nums6 = { 3, 6 };
        int[] nums7 = { 0, 1, 2, 5 };

        System.out.println(Arrays.toString(largestPower(nums1)));
        System.out.println(Arrays.toString(largestPower(nums2)));
        System.out.println(Arrays.toString(largestPower(nums3)));
        System.out.println(Arrays.toString(largestPower(nums4)));
        System.out.println(Arrays.toString(largestPower(nums5)));
        System.out.println(Arrays.toString(largestPower(nums6)));
        System.out.println(Arrays.toString(largestPower(nums7)));
    }
}
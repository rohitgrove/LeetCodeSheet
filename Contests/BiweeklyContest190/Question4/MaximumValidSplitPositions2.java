import java.util.HashSet;
import java.util.Set;

public class MaximumValidSplitPositions2 {
    public static int maxValidSplits(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }

        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = gcd(prefix[i - 1], nums[i]);
        }

        suffix[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = gcd(suffix[i + 1], nums[i]);
        }

        int baseScore = 0;
        Set<Integer> candidates = new HashSet<>();

        for (int i = 0; i < n - 1; i++) {
            if (prefix[i] == suffix[i + 1]) {
                baseScore++;
            } else {
                candidates.add(i);
                candidates.add(i + 1);
            }
        }

        int maxScore = baseScore;

        if (candidates.isEmpty() || maxScore == n - 2) {
            return maxScore;
        }

        for (int skip : candidates) {
            int score = countSplitsOptimized(nums, skip, n);
            maxScore = Math.max(maxScore, score);

            if (maxScore == n - 2) {
                return maxScore;
            }
        }

        return maxScore;
    }

    public static int countSplitsOptimized(int[] nums, int skip, int n) {
        int m = n - 1;
        if (m < 2)
            return 0;

        int[] left = new int[m];
        int g = 0;
        int writeIdx = 0;
        for (int i = 0; i < n; i++) {
            if (i != skip) {
                g = gcd(g, nums[i]);
                left[writeIdx++] = g;
            }
        }

        int[] right = new int[m];
        g = 0;
        int readIdx = m - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (i != skip) {
                g = gcd(g, nums[i]);
                right[readIdx--] = g;
            }
        }

        int count = 0;
        for (int i = 0; i < m - 1; i++) {
            if (left[i] == right[i + 1]) {
                count++;
            }
        }

        return count;
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        int nums1[] = { 10, 30, 15, 10 };
        System.out.println(maxValidSplits(nums1));
        int nums2[] = { 2, 10, 14 };
        System.out.println(maxValidSplits(nums2));
        int nums3[] = { 2, 4 };
        System.out.println(maxValidSplits(nums3));
    }
}

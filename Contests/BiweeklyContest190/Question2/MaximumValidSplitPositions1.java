public class MaximumValidSplitPositions1 {
    public static int maxValidSplits(int[] nums) {
        int maxScore = 0;

        maxScore = Math.max(maxScore, countValidSplits(nums));

        for (int skip = 0; skip < nums.length; skip++) {
            int[] arr = new int[nums.length - 1];
            int idx = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i != skip) {
                    arr[idx++] = nums[i];
                }
            }
            maxScore = Math.max(maxScore, countValidSplits(arr));
        }

        return maxScore;
    }

    public static int countValidSplits(int[] arr) {
        int m = arr.length;
        if (m < 2) {
            return 0;
        }

        int[] prefixGcd = new int[m];
        prefixGcd[0] = arr[0];
        for (int i = 1; i < m; i++) {
            prefixGcd[i] = gcd(prefixGcd[i - 1], arr[i]);
        }

        int[] suffixGcd = new int[m];
        suffixGcd[m - 1] = arr[m - 1];
        for (int i = m - 2; i >= 0; i--) {
            suffixGcd[i] = gcd(suffixGcd[i + 1], arr[i]);
        }

        int count = 0;

        for (int i = 0; i < m - 1; i++) {
            int leftGcd = prefixGcd[i];
            int rightGcd = suffixGcd[i + 1];

            if (leftGcd == rightGcd) {
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

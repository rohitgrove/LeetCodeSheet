import java.util.Arrays;

public class ValidKUniqueSubarrays1 {
    public static boolean[] validSubarrays(int[] nums, int k, int[][] queries) {
        int n = nums.length;
        int q = queries.length;
        Query[] qs = new Query[q];

        for (int i = 0; i < q; i++) {
            qs[i] = new Query(queries[i][0], queries[i][1], i);
        }

        int blockSize = (int) Math.sqrt(n) + 1;
        Arrays.sort(qs, new Comp(blockSize));
        boolean[] ans = new boolean[q];
        int[] freq = new int[100001];

        int left = 0;
        int right = -1;
        int distinct = 0;
        int oddCount = 0;

        for (int i = 0; i < qs.length; i++) {
            Query query = qs[i];
            int L = query.left;
            int R = query.right;

            while (left > L) {
                left--;
                int value = nums[left];

                if (freq[value] == 0) {
                    distinct++;
                    oddCount++;
                } else if ((freq[value] & 1) == 1) {
                    oddCount--;
                } else {
                    oddCount++;
                }

                freq[value]++;
            }

            while (right < R) {
                right++;
                int value = nums[right];

                if (freq[value] == 0) {
                    distinct++;
                    oddCount++;
                } else if ((freq[value] & 1) == 1) {
                    oddCount--;
                } else {
                    oddCount++;
                }

                freq[value]++;
            }

            while (left < L) {
                int value = nums[left];

                freq[value]--;

                if (freq[value] == 0) {
                    distinct--;
                    oddCount--;
                } else if ((freq[value] & 1) == 1) {
                    oddCount++;
                } else {
                    oddCount--;
                }

                left++;
            }

            while (right > R) {
                int value = nums[right];

                freq[value]--;

                if (freq[value] == 0) {
                    distinct--;
                    oddCount--;
                } else if ((freq[value] & 1) == 1) {
                    oddCount++;
                } else {
                    oddCount--;
                }

                right--;
            }

            if (distinct == k && oddCount == 0) {
                ans[query.index] = true;
            }
        }

        return ans;
    }

    public static void printArr(boolean ans[]) {
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 2, 2, 1 };
        int queries1[][] = { { 0, 1 },
                { 0, 3 },
                { 1, 2 } };
        printArr(validSubarrays(nums1, 2, queries1));

        int nums2[] = { 3, 3, 3 };
        int queries2[][] = { { 1, 2 },
                { 0, 2 } };
        printArr(validSubarrays(nums2, 1, queries2));
    }
}

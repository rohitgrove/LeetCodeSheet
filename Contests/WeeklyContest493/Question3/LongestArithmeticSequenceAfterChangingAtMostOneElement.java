public class LongestArithmeticSequenceAfterChangingAtMostOneElement {
    public static int longestArithmetic(int[] nums) {
        int[] sivarnolqe = nums;
        int n = sivarnolqe.length;

        if (n <= 3) {
            return n;
        }

        int[] L = new int[n];
        int[] R = new int[n];

        L[0] = 1;
        L[1] = 2;
        for (int i = 2; i < n; i++) {
            if (sivarnolqe[i] - sivarnolqe[i - 1] == sivarnolqe[i - 1] - sivarnolqe[i - 2]) {
                L[i] = L[i - 1] + 1;
            } else {
                L[i] = 2;
            }
        }

        R[n - 1] = 1;
        R[n - 2] = 2;
        for (int i = n - 3; i >= 0; i--) {
            if (sivarnolqe[i + 1] - sivarnolqe[i] == sivarnolqe[i + 2] - sivarnolqe[i + 1]) {
                R[i] = R[i + 1] + 1;
            } else {
                R[i] = 2;
            }
        }

        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0)
                maxLen = Math.max(maxLen, L[i - 1] + 1);

            if (i < n - 1)
                maxLen = Math.max(maxLen, R[i + 1] + 1);

            if (i > 0 && i < n - 1) {
                int gap = sivarnolqe[i + 1] - sivarnolqe[i - 1];
                if (gap % 2 == 0) {
                    int d = gap / 2;
                    int leftCount = 1;
                    int rightCount = 1;

                    if (i >= 2 && sivarnolqe[i - 1] - sivarnolqe[i - 2] == d) {
                        leftCount = L[i - 1];
                    }
                    if (i <= n - 3 && sivarnolqe[i + 2] - sivarnolqe[i + 1] == d) {
                        rightCount = R[i + 1];
                    }
                    maxLen = Math.max(maxLen, leftCount + rightCount + 1);
                }
            }
        }

        for (int x : L) {
            maxLen = Math.max(maxLen, x);
        }

        return Math.min(maxLen, n);
    }

    public static void main(String[] args) {
        int[] nums1 = { 9, 7, 5, 10, 1 };
        System.out.println(longestArithmetic(nums1));

        int[] nums2 = { 1, 2, 6, 7 };
        System.out.println(longestArithmetic(nums2));
    }
}
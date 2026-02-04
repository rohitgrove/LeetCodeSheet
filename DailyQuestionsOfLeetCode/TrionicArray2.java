public class TrionicArray2 {
    public static long maxSumTrionic(int[] nums) {
        long INF = (long) -1e17;
        long result = INF, incStart = INF, decMid = INF, incEnd = INF;
        long prev = nums[0];

        for (int i = 1; i < nums.length; i++) {
            long curr = nums[i];
            long nextIncStart = INF, nextDecMid = INF, nextIncEnd = INF;

            if (curr > prev) { // increasing, update first and third state
                nextIncStart = Math.max(incStart, prev) + curr;
                nextIncEnd = Math.max(decMid, incEnd) + curr;
            } else if (curr < prev) { // decreasing, update second state
                nextDecMid = Math.max(incStart, decMid) + curr;
            }

            incStart = nextIncStart;
            decMid = nextDecMid;
            incEnd = nextIncEnd;

            result = Math.max(result, incEnd);
            prev = curr;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = { 0, -2, -1, -3, 0, 2, -1 };
        System.out.println(maxSumTrionic(nums1));
        int nums2[] = { 1, 4, 2, 7 };
        System.out.println(maxSumTrionic(nums2));
    }
}

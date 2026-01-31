public class ThirdMaximumNumber {
    public static int thirdMax(int[] nums) {
        long firstMax = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;

        for (int num : nums) {
            // skip duplicates
            if (num == firstMax || num == secondMax || num == thirdMax) {
                continue;
            }

            if (num > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = num;
            } 
            else if (num > secondMax) {
                thirdMax = secondMax;
                secondMax = num;
            } 
            else if (num > thirdMax) {
                thirdMax = num;
            }
        }

        // agar 3 distinct elements nahi mile
        return thirdMax == Long.MIN_VALUE ? (int) firstMax : (int) thirdMax;
    
    }

    public static void main(String[] args) {
        int nums1[] = { 3, 2, 1 };
        System.out.println(thirdMax(nums1));
        int nums2[] = { 2, 2, 3, 1 };
        System.out.println(thirdMax(nums2));
        int nums3[] = { 1, 2, 5, 4, 3, 1 };
        System.out.println(thirdMax(nums3));
    }
}

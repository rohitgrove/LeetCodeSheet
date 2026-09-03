public class ConstructUniformParityArray2 {
    public static boolean bruteForce(int[] nums) {
        int smallestOdd = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num % 2 == 1) {
                smallestOdd = Math.min(smallestOdd, num);
            }
        }

        // Already all even
        if (smallestOdd == Integer.MAX_VALUE) {
            return true;
        }

        // Check whether every even number can become odd
        for (int num : nums) {
            if (num % 2 == 0 && num <= smallestOdd) {
                return false;
            }
        }

        return true;
    }

    public static boolean optimizedApproach(int[] nums) {
        int mn = Integer.MAX_VALUE;
        int oddCnt = 0;
        for (int x : nums) {
            mn = Math.min(mn, x);
            if (x % 2 == 1) {
                oddCnt++;
            }
        }
        // min Element is ODD(remaining even > min) or All Even!
        return mn % 2 != 0 || oddCnt == 0;
    }

    public static boolean uniformArray(int[] nums1) {
        return optimizedApproach(nums1);
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 4, 7 };
        System.out.println(uniformArray(nums1));
        int nums2[] = { 2, 3 };
        System.out.println(uniformArray(nums2));
        int nums3[] = { 4, 6 };
        System.out.println(uniformArray(nums3));
    }
}

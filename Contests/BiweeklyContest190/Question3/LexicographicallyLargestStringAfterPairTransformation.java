public class LexicographicallyLargestStringAfterPairTransformation {
    public static String[] largestString(int[] nums) {
        String[] ans = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = getLargest(nums[i]);
        }
        return ans;
    }

    public static String getLargest(int x) {
        StringBuilder res = new StringBuilder();
        int zValue = (int) Math.pow(2, 25);

        while (x > 0) {
            if (zValue <= x) {
                res.append('z');
                x -= zValue;
                continue;
            }
            int power = Integer.highestOneBit(x);
            char ch = (char) ('a' + Integer.numberOfTrailingZeros(power));
            res.append(ch);
            x = x - power;
        }

        return res.toString();
    }

    public static void printAns(String arr[]) {
        for (String str : arr) {
            System.out.print(str + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums1[] = { 2, 5, 7 };
        printAns(largestString(nums1));
        int nums2[] = { 3, 9, 1 };
        printAns(largestString(nums2));
    }
}

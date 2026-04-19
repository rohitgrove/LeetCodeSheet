import java.util.HashMap;

public class lengthOfTheLongestSubAarayWithSumZero {
    public static int maxLength(int nums[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxlen = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum == 0) {
                maxlen = Math.max(maxlen, i + 1);
            } else if (!map.containsKey(sum)) {
                map.put(sum, i);
            } else {
                maxlen = Math.max(maxlen, i - map.get(sum));
            }
        }

        return maxlen;
    }

    public static void main(String[] args) {
        int nums1[] = { 1, -1, 3, 2, -2, -3, 3 };
        System.out.println(maxLength(nums1));
        int nums2[] = { 15, -2, 2, -8, 1, 7, 10, 23 };
        System.out.println(maxLength(nums2));
    }
}

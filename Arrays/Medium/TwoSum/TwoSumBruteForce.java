import java.util.Arrays;

public class TwoSumBruteForce {
    public static int[] twoSum(int[] nums, int target) {
        Pair numsPair[] = new Pair[nums.length];

        for (int i = 0; i < numsPair.length; i++) {
            numsPair[i] = new Pair(nums[i], i);
        }

        Arrays.sort(numsPair, (a, b) -> a.element - b.element);

        int start = 0;
        int end = numsPair.length - 1;

        while (start < end) {
            int sum = numsPair[start].element + numsPair[end].element;
            if (sum == target) {
                return new int[] { numsPair[start].index, numsPair[end].index };
            } else if (sum < target) {
                start++;
            } else {
                end--;
            }
        }

        return new int[] { -1, -1 };
    }

    public static void printAns(int ans[]) {
        System.out.println(ans[0] + " " + ans[1]);
    }

    public static void main(String[] args) {
        int nums1[] = { 2, 7, 11, 15 };
        printAns(twoSum(nums1, 9));
        int nums2[] = { 3, 2, 4 };
        printAns(twoSum(nums2, 6));
    }
}

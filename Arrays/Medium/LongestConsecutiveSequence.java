import java.util.HashSet;
import java.util.TreeSet;

public class LongestConsecutiveSequence {
    public static int bruteForce(int nums[]) {
        if (nums.length == 0) {
            return 0;
        }
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int count = 0;
        int maxCount = 0;
        for (int num : set) {
            if (set.contains(num + 1)) {
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }

        return maxCount + 1;
    }

    public static int optimizedApproach(int nums[]) {
        if (nums.length == 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int maxCount = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currCount = 1;
                int currNum = num;

                while (set.contains(currNum + 1)) {
                    currCount++;
                    currNum++;
                }
                maxCount = Math.max(maxCount, currCount);
            }
        }

        return maxCount;
    }

    public static int longestConsecutive(int[] nums) {
        return optimizedApproach(nums);
    }

    public static void main(String[] args) {
        int nums1[] = { 100, 4, 200, 1, 3, 2 };
        System.out.println(longestConsecutive(nums1));
        int nums2[] = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
        System.out.println(longestConsecutive(nums2));
        int nums3[] = { 1, 0, 1, 2 };
        System.out.println(longestConsecutive(nums3));
        int nums4[] = { 1, 2, 6, 7, 8 };
        System.out.println(longestConsecutive(nums4));
    }
}

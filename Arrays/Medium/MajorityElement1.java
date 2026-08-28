import java.util.Arrays;
import java.util.HashMap;

public class MajorityElement1 {
    public static int bruteForce(int nums[]) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static int betterApproach(int nums[]) {
        HashMap<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
        }

        int half = nums.length / 2;
        for (int key : countMap.keySet()) {
            if (countMap.get(key) > half) {
                return key;
            }
        }

        return -1;
    }

    public static int optimizedApproach(int nums[]) {
        int freq = 0, ans = 0;

        for (int i = 0; i < nums.length; i++) {
            if (freq == 0) {
                ans = nums[i];
            }

            if (ans == nums[i]) {
                freq++;
            } else {
                freq--;
            }
        }

        return ans;
    }

    public static int majorityElement(int[] nums) {
        return optimizedApproach(nums);
    }

    public static void main(String[] args) {
        int nums1[] = { 3, 2, 3 };
        System.out.println(majorityElement(nums1));
        int nums2[] = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println(majorityElement(nums2));
    }
}

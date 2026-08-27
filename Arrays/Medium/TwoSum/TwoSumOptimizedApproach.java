import java.util.HashMap;

public class TwoSumOptimizedApproach {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(target - nums[i])) {
                return new int[] { hm.get(target - nums[i]), i };
            }
            hm.put(nums[i], i);
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

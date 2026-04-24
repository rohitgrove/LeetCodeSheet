import java.util.HashMap;

public class SingleNumber {
    public static int singleNumberBruteForce(int nums[]) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }

        return -1;
    }

    public static int singleNumberOptimized(int nums[]) {
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i];
        }

        return ans;
    }

    public static int singleNumber(int[] nums) {
        return singleNumberOptimized(nums);
    }

    public static void main(String[] args) {
        int nums1[] = { 2, 2, 1 };
        System.out.println(singleNumber(nums1));
        int nums2[] = { 4, 1, 2, 1, 2 };
        System.out.println(singleNumber(nums2));
        int nums3[] = { 1 };
        System.out.println(singleNumber(nums3));
    }
}

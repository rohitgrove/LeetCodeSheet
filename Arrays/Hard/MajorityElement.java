import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorityElement {
    public static List<Integer> bruteForce(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int target = nums.length / 3;
        for (int key : map.keySet()) {
            if (map.get(key) > target) {
                ans.add(key);
            }
        }

        return ans;
    }

    public static List<Integer> majorityElement(int[] nums) {
        return bruteForce(nums);
    }

    public static void main(String[] args) {
        int nums1[] = { 3, 2, 3 };
        System.out.println(majorityElement(nums1));
        int nums2[] = { 1, 2 };
        System.out.println(majorityElement(nums2));
    }
}

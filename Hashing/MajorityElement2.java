import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorityElement2 {
    public static List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            countMap.putIfAbsent(nums[i], 0);
            countMap.put(nums[i], countMap.get(nums[i]) + 1);
        }

        int halfBy3 = nums.length / 3;
        List<Integer> ans = new ArrayList<>();

        for (int key : countMap.keySet()) {
            if (countMap.get(key) > halfBy3) {
                ans.add(key);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int nums1[] = { 3, 2, 3 };
        System.out.println(majorityElement(nums1));
        int nums2[] = { 1 };
        System.out.println(majorityElement(nums2));
        int nums3[] = { 1, 2 };
        System.out.println(majorityElement(nums3));
    }
}

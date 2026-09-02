import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorityElement2 {
    public static List<Integer> bruteForce(int nums[]) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int num = nums.length / 3;
        List<Integer> ans = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) > num) {
                ans.add(key);
            }
        }

        return ans;
    }

    public static List<Integer> optimizedAppraoch(int[] nums) {
        int candidate1 = 0, candidate2 = 0, count1 = 0, count2 = 0;

        for (int num : nums) {
            if (candidate1 == num) {
                count1++;
            } else if (candidate2 == num) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = count2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }

        List<Integer> ans = new ArrayList<>();
        if (count1 > nums.length / 3) {
            ans.add(candidate1);
        }
        if (count2 > nums.length / 3) {
            ans.add(candidate2);
        }

        return ans;
    }

    public static List<Integer> majorityElement(int[] nums) {
        return optimizedAppraoch(nums);
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

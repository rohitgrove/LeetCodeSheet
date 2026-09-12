import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CountValuesWithEquallySpacedOccurrences2 {
    public static int countSpecialIntegers(int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        int ans = 0;

        for (List<Integer> list : map.values()) {
            if (list.size() < 3) {
                continue;
            }
            int gap = list.get(1) - list.get(0);
            boolean special = true;
            for (int i = 2; i < list.size(); i++) {
                int currentGap = list.get(i) - list.get(i - 1);
                if (currentGap != gap) {
                    special = false;
                    break;
                }
            }
            if (special) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 8, 1, 5, 1, 5, 8, 5 };
        System.out.println(countSpecialIntegers(nums1));
        int nums2[] = { 8, 8, 8, 8 };
        System.out.println(countSpecialIntegers(nums2));
        int nums3[] = { 8, 6, 6, 8, 8 };
        System.out.println(countSpecialIntegers(nums3));
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class ReaarangeArrayByRemovingDistinctValues {
    public static int[] rearrangeArray(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] ans = new int[nums.length];
        int index = 0;

        while (!map.isEmpty()) {
            List<Integer> keys = new ArrayList<>(map.keySet());

            for (int key : keys) {
                ans[index++] = key;

                int count = map.get(key);

                if (count == 1) {
                    map.remove(key);
                } else {
                    map.put(key, count - 1);
                }
            }
        }

        return ans;
    }

    public static void printArr(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums1 = { 3, 3, 3, 1, 1, 2 };
        printArr(rearrangeArray(nums1));
        int[] nums2 = { 7, 7, 4, 4, 4 };
        printArr(rearrangeArray(nums2));
    }
}

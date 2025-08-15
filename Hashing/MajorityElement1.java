import java.util.HashMap;

public class MajorityElement1 {
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();

        for (int ele : nums) {
            countMap.putIfAbsent(ele, 0);
            countMap.put(ele, countMap.get(ele) + 1);
        }

        int half = nums.length / 2;
        for (int ele : nums) {
            if (countMap.get(ele) > half) {
                return ele;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int nums1[] = { 3, 2, 3 };
        System.out.println(majorityElement(nums1));
        int nums2[] = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println(majorityElement(nums2));
    }
}

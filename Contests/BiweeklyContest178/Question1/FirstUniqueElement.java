import java.util.HashMap;

public class FirstUniqueElement {
    public static int firstUniqueEven(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            if (num % 2 == 0 && map.get(num) == 1) {
                return num;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = { 3, 4, 2, 5, 4, 6 };
        System.out.println(firstUniqueEven(nums1));

        int[] nums2 = { 4, 4 };
        System.out.println(firstUniqueEven(nums2));
    }
}

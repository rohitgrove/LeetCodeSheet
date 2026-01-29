import java.util.HashMap;

public class SumOfUnique {
    public static int sumOfUnique1(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.putIfAbsent(num, 0);
            count.put(num, count.get(num) + 1);
        }

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count.get(nums[i]) == 1) {
                sum += nums[i];
            }
        }

        return sum;
    }

    public static int sumOfUnique2(int[] nums) {
        int count[] = new int[101];

        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count[nums[i]] == 1) {
                sum += nums[i];
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 2, 3, 2 };
        System.out.println(sumOfUnique2(nums1));
        int nums2[] = { 1, 1, 1, 1, 1 };
        System.out.println(sumOfUnique2(nums2));
        int nums3[] = { 1, 2, 3, 4, 5 };
        System.out.println(sumOfUnique2(nums3));
    }
}

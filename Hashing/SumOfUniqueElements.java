import java.util.HashMap;

public class SumOfUniqueElements {
    public static int sumOfUnique1(int[] nums) {
        int largest = 0;
        for (int i = 0; i < nums.length; i++) {
            largest = Math.max(nums[i], largest);
        }

        int count[] = new int[largest + 1];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        int sum = 0;

        for (int i = 0; i < count.length; i++) {
            if (count[i] == 1) {
                sum += i;
            }
        }

        return sum;
    }

    public static int sumOfUnique2(int[] nums) {
        HashMap<Integer, Integer> counts = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (counts.containsKey(nums[i])) {
                counts.put(nums[i], counts.get(nums[i]) + 1);
            } else {
                counts.put(nums[i], 1);
            }
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (counts.get(nums[i]) == 1) {
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

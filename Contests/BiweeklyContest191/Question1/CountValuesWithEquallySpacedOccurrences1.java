import java.util.ArrayList;
import java.util.List;

public class CountValuesWithEquallySpacedOccurrences1 {
    public static int countSpecialIntegers(int[] nums) {
        List<Integer>[] positions = new ArrayList[101];

        for (int i = 0; i <= 100; i++) {
            positions[i] = new ArrayList<>();
        }

        for (int i = 0; i < nums.length; i++) {
            positions[nums[i]].add(i);
        }

        int ans = 0;

        for (int x = 1; x <= 100; x++) {
            if (positions[x].size() == 3) {
                int i1 = positions[x].get(0);
                int i2 = positions[x].get(1);
                int i3 = positions[x].get(2);

                if (i2 - i1 == i3 - i2) {
                    ans++;
                }
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

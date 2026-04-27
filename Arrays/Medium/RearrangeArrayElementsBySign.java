import java.util.ArrayList;
import java.util.List;

public class RearrangeArrayElementsBySign {
    public static int[] bruteForce(int[] nums) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for (int num : nums) {
            if (num < 0) {
                neg.add(num);
            } else {
                pos.add(num);
            }
        }

        int ans[] = new int[nums.length];
        int i = 0;
        int j = 0;
        while (i < pos.size()) {
            ans[j++] = pos.get(i);
            ans[j++] = neg.get(i);
            i++;
        }

        return ans;
    }

    public static int[] optimizeApproach(int[] nums) {
        int ans[] = new int[nums.length];
        int odd = 1, even = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > 0) {
                ans[even] = num;
                even += 2;
            } else {
                ans[odd] = nums[i];
                odd += 2;
            }
        }

        return ans;
    }

    public static int[] rearrangeArray(int[] nums) {
        return optimizeApproach(nums);
    }

    public static void printArr(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums1[] = { 3, 1, -2, -5, 2, -4 };
        printArr(rearrangeArray(nums1));
        int nums2[] = { -1, 1 };
        printArr(rearrangeArray(nums2));
    }
}

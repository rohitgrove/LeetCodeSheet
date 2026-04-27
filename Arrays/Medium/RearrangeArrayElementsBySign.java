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


    // This approach works when saare pos elements and negetive elements inme se 1 saath nahi ho sakte matlab [-1, -3, 4, 5] aise na ho par aise chal jayenge [-1, 2, -3, 4]
    public int[] optimizeApproach2(int[] nums) {
        int n = nums.length;
        int pos = 0, neg = 1;
        while (pos < n && neg < n) {
            if (nums[pos] >= 0) {
                pos += 2;
            } else if (nums[neg] < 0) {
                neg += 2;
            } else {
                int temp = nums[pos];
                nums[pos] = nums[neg];
                nums[neg] = temp;
            }
        }
        return nums;
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

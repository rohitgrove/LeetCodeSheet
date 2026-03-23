import java.util.ArrayList;
import java.util.List;

public class SortArrayByParity {
    public static int[] bruteForce(int nums[]) {
        List<Integer> odds = new ArrayList<>();
        List<Integer> evens = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                evens.add(nums[i]);
            } else {
                odds.add(nums[i]);
            }
        }

        int idx = 0;

        for (int i = 0; i < evens.size(); i++) {
            nums[idx++] = evens.get(i);
        }

        for (int i = 0; i < odds.size(); i++) {
            nums[idx++] = odds.get(i);
        }

        return nums;
    }

    public static int[] optimizedApproach1(int nums[]) {
        int n = nums.length;
        int even = 0;
        int odd = n - 1;

        while (even < odd) {
            if (nums[even] % 2 == 0) {
                even++;
            } else if (nums[odd] % 2 != 0) {
                odd--;
            } else {
                int temp = nums[even];
                nums[even] = nums[odd];
                nums[odd] = temp;
                even++;
                odd--;
            }
        }

        return nums;
    }

    public static int[] sortArrayByParity(int[] nums) {
        return optimizedApproach1(nums);
    }

    public static void printArr(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums1[] = { 3, 1, 2, 4 };
        printArr(sortArrayByParity(nums1));
    }
}

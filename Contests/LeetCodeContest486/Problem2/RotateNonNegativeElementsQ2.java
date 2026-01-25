import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RotateNonNegativeElementsQ2 {
    public static int[] rotateElements(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();

        for (int x : nums) {
            if (x >= 0) {
                list.add(x);
            }
        }

        int m = list.size();
        if (m == 0) return nums;

        k = k % m;

        Collections.rotate(list, -k);

        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                nums[i] = list.get(idx++);
            }
        }

        return nums;
    }

    public static void printArr(int arr[]) {
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums1[] = { 1, -2, 3, -4 };
        printArr(rotateElements(nums1, 3));
        int nums2[] = { -3, -2, 7 };
        printArr(rotateElements(nums2, 1));
        int nums3[] = { 5, 4, -9, 6 };
        printArr(rotateElements(nums3, 2));
    }
}

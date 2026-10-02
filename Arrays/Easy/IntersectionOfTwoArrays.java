import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        List<Integer> ans = new ArrayList<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                ans.add(num);
                set.remove(num);
            }
        }

        int res[] = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    public static void printArr(int arr[]) {
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 2, 2, 1 }, nums2[] = { 2, 2 };
        printArr(intersection(nums1, nums2));
        int nums3[] = { 4, 9, 5 }, nums4[] = { 9, 4, 9, 8, 4 };
        printArr(intersection(nums3, nums4));
    }
}

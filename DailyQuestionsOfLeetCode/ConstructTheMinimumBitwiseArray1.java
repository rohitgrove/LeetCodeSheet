import java.util.ArrayList;
import java.util.List;

public class ConstructTheMinimumBitwiseArray1 {
    public static int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int val = nums.get(i);

            if (val % 2 == 0) {
                ans[i] = -1;
            } else {
                long t = (long) val + 1;

                long lowbit = t & -t;

                ans[i] = val - (int) (lowbit >> 1);
            }
        }

        return ans;
    }

    public static void printArr(int ans[]) {
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> nums1 = new ArrayList<>();
        nums1.add(2);
        nums1.add(3);
        nums1.add(5);
        nums1.add(7);
        printArr(minBitwiseArray(nums1));
    
        List<Integer> nums2 = new ArrayList<>();
        nums2.add(11);
        nums2.add(13);
        nums2.add(31);
        printArr(minBitwiseArray(nums2));
    }
}

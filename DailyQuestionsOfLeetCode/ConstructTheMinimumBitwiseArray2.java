import java.util.ArrayList;
import java.util.List;

public class ConstructTheMinimumBitwiseArray2 {
    public static int[] minBitwiseArray(List<Integer> nums) {
        int ans[] = new int[nums.size()];
        for(int i = 0; i < nums.size(); i++) {
            int n = nums.get(i);
            if(n != 2) ans[i] = n - ((n + 1) & (-n - 1)) / 2;
            else ans[i] = -1;
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
import java.util.ArrayList;
import java.util.Collections;

public class ArrayLeaders {
    public static ArrayList<Integer> leaders(int nums[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (nums.length == 0) {
            return ans;
        }

        int max = nums[nums.length - 1];
        ans.add(max);

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= max) {
                ans.add(nums[i]);
                max = nums[i];
            }
        }

        Collections.reverse(ans);

        return ans;
    }

    public static void main(String[] args) {
        int arr1[] = { 16, 17, 4, 3, 5, 2 };
        System.out.println(leaders(arr1));
        int arr2[] = { 10, 4, 2, 4, 1 };
        System.out.println(leaders(arr2));
        int arr3[] = { 5, 10, 20, 40 };
        System.out.println(leaders(arr3));
        int arr4[] = { 30, 10, 10, 5 };
        System.out.println(leaders(arr4));
    }
}

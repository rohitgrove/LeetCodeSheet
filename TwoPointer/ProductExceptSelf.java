import java.util.Arrays;

public class ProductExceptSelf {
    public static int[] productExceptSelf(int[] a) {
        int n = a.length;
        int[] res = new int[n];

        Arrays.fill(res, 1);

        res[0] = 1;
        int ans = a[0];
        for (int i = 1; i < n; ++i) {
            res[i] = ans;
            ans *= a[i];
        }

        ans = a[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            res[i] *= ans;
            ans *= a[i];
        }

        return res;
    }

    public static void printArr(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4 };
        printArr(nums);
        printArr(productExceptSelf(nums));
    }
}

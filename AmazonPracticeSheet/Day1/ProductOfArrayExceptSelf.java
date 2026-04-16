public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int leftProduct[] = new int[nums.length];
        int rightProduct[] = new int[nums.length];

        int product = 1;

        for (int i = 0; i < leftProduct.length; i++) {
            leftProduct[i] = product;
            product = product * nums[i];
        }

        product = 1;
        for (int i = rightProduct.length - 1; i >= 0; i--) {
            rightProduct[i] = product;
            product = product * nums[i];
        }

        int productArr[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            productArr[i] = leftProduct[i] * rightProduct[i];
        }
        return productArr;
    }

    public static int[] productExceptSelfSO(int[] nums) {
        int n = nums.length;
        int productArr[] = new int[n];
        int product = 1;

        for (int i = 0; i < n; i++) {
            productArr[i] = product;
            product *= nums[i];
        }

        product = 1;
        for (int i = n - 1; i >= 0; i--) {
            productArr[i] *= product;
            product *= nums[i];
        }

        return productArr;
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4 };
        printArr(nums);
        printArr(productExceptSelfSO(nums));
    }
}

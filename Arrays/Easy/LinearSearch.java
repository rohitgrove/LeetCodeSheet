public class LinearSearch {
    public static int search(int nums[], int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int arr1[] = { 1, 2, 3, 4, 5 };
        System.out.println(search(arr1, 3));
        int arr2[] = { 5, 4, 3, 2, 1 };
        System.out.println(search(arr2, 5));
    }
}

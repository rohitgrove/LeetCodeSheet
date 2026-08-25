public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0; // Pointer to place the next non-zero element

        while (i < nums.length) {
            if (nums[i] != 0) {
                // Swap current element with the element at index j
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++; // Move j to the next index for placing non-zero
            }
            i++;
        }
    }

    public static void printArr(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums[] = { 0, 1, 0, 3, 12 };
        System.out.println("Before Moves: ");
        printArr(nums);
        moveZeroes(nums);
        System.out.println("After Moves: ");
        printArr(nums);
    }
}

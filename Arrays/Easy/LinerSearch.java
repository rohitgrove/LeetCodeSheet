public class LinerSearch {
    public static int linerSearch(int nums[], int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int nums[] = { 12, 25, 8, 10, 32 };
        System.out.println(linerSearch(nums, 8));
    }
}

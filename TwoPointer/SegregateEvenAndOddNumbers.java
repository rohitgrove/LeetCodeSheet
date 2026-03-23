import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SegregateEvenAndOddNumbers {
    public static void bruteForce(int nums[]) {
        List<Integer> odds = new ArrayList<>();
        List<Integer> evens = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                evens.add(nums[i]);
            } else {
                odds.add(nums[i]);
            }
        }

        Collections.sort(odds);
        Collections.sort(evens);

        int idx = 0;

        for (int i = 0; i < evens.size(); i++) {
            nums[idx++] = evens.get(i);
        }

        for (int i = 0; i < odds.size(); i++) {
            nums[idx++] = odds.get(i);
        }
    }

    public static void optimizedApproach1(int nums[]) {
        int n = nums.length;
        int even = 0;
        int odd = n - 1;

        while (even < odd) {
            if (nums[even] % 2 == 0) {
                even++;
            } else if (nums[odd] % 2 != 0) {
                odd--;
            } else {
                int temp = nums[even];
                nums[even] = nums[odd];
                nums[odd] = temp;
                even++;
                odd--;
            }
        }

        int partition = 0;
        while (partition < n && nums[partition] % 2 == 0) {
            partition++;
        }

        Arrays.sort(nums, 0, partition);

        Arrays.sort(nums, partition, n);
    }

    public static void optimizedApproach2(int nums[]) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) {
                if (nums[i] == 0) {
                    nums[i] = Integer.MIN_VALUE;
                } else {
                    nums[i] = -nums[i];
                }
            }
        }

        Arrays.sort(nums);

        int idx = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == Integer.MIN_VALUE) {
                nums[i] = 0;
            } else if (nums[i] < 0) {
                nums[i] = -nums[i];
            }
            if (nums[i] % 2 == 0) {
                idx++;
            }
        }

        Arrays.sort(nums, 0, idx);
    }

    public static boolean compare(int a, int b) {
        boolean isAOdd = (a % 2 != 0);
        boolean isBOdd = (b % 2 != 0);

        // Both even → ascending
        if (!isAOdd && !isBOdd) {
            return a < b;
        }

        // Both odd → descending
        if (isAOdd && isBOdd) {
            return a > b;
        }

        // Even comes first (CHANGE HERE)
        return !isAOdd;
    }

    public static void optimizedApproach3(int nums[]) {
        Integer[] temp = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }

        // Step 2: sort using comparator
        Arrays.sort(temp, (a, b) -> {
            if (compare(a, b)) {
                return -1;
            } else if (compare(b, a)) {
                return 1;
            } else {
                return 0;
            }
        });

        // Step 3: copy back to int[]
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }

    public static void segregateEvenOdd(int[] nums) {
        optimizedApproach3(nums);
    }

    public static void printArr(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums1[] = { 12, 34, 45, 9, 8, 90, 3 };
        segregateEvenOdd(nums1);
        printArr(nums1);
        int nums2[] = { 0, 1, 2, 3, 4 };
        segregateEvenOdd(nums2);
        printArr(nums2);
        int nums3[] = { 10, 22, 4, 6 };
        segregateEvenOdd(nums3);
        printArr(nums3);
    }
}

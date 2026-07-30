import java.util.Arrays;
import java.util.HashMap;

class Pair {
    public int number;
    public int index;

    public Pair(int number, int index) {
        this.number = number;
        this.index = index;
    }
}

public class TwoSum {
    public static int[] bruteForce(int nums[], int target) {
        Pair arr[] = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = new Pair(nums[i], i);
        }

        Arrays.sort(arr, (a, b) -> a.number - b.number);

        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int sum = arr[start].number + arr[end].number;
            if (sum == target) {
                return new int[] { arr[start].index, arr[end].index };
            } else if (sum < target) {
                start++;
            } else {
                end--;
            }
        }

        return new int[] { -1, -1 };
    }

    public static int[] optimizedApproach(int nums[], int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] { map.get(target - nums[i]), i };
            }
            map.put(nums[i], i);
        }
        return new int[] { -1, -1 };
    }

    public static int[] twoSum(int[] nums, int target) {
        return optimizedApproach(nums, target);
    }

    public static void printAns(int ans[]) {
        System.out.println(ans[0] + " " + ans[1]);
    }

    public static void main(String[] args) {
        int nums1[] = { 2, 7, 11, 15 };
        printAns(twoSum(nums1, 9));
        int nums2[] = { 3, 2, 4 };
        printAns(twoSum(nums2, 6));
    }
}

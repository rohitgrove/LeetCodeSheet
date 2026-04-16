// https://leetcode.com/problems/two-sum/description/

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static int[] bruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }

        return new int[] { -1, -1 };
    }

    public static int[] optimizedApproach1(int[] nums, int target) {
        int[][] numsPair = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            numsPair[i][0] = nums[i];
            numsPair[i][1] = i;
        }

        Arrays.sort(numsPair, (a, b) -> a[0] - b[0]);

        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if (numsPair[start][0] + numsPair[end][0] == target) {
                return new int[] { numsPair[start][1], numsPair[end][1] };
            }

            if (numsPair[start][0] + numsPair[end][0] < target) {
                start++;
            } else {
                end--;
            }
        }

        return new int[] { -1, -1 };
    }

    public static int[] optimizedApproach2(int[] nums, int target) {
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
        return optimizedApproach2(nums, target);
    }

    public static void printAns(int ans[]) {
        System.out.println(ans[0] + ", " + ans[1]);
    }

    public static void main(String[] args) {
        int nums1[] = { 2, 7, 11, 15 }, target1 = 9;
        printAns(twoSum(nums1, target1));
        int nums2[] = { 3, 2, 4 }, target2 = 6;
        printAns(twoSum(nums2, target2));
    }
}
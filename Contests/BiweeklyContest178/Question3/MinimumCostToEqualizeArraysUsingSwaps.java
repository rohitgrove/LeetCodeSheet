import java.util.HashMap;

public class MinimumCostToEqualizeArraysUsingSwaps {
    public static int minCost(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int x : nums1) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (int x : nums2) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (int v : map.values()) {
            if (v % 2 != 0) {
                return -1;
            }
        }

        HashMap<Integer, Integer> count = new HashMap<>();

        for (int x : nums1) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }
        for (int x : nums2) {
            count.put(x, count.getOrDefault(x, 0) - 1);
        }

        int cost = 0;

        for (int v : count.values()) {
            cost += Math.abs(v);
        }

        return cost / 4;
    }

    public static void main(String[] args) {

        int[] nums1 = { 10, 20 };
        int[] nums2 = { 20, 10 };
        System.out.println(minCost(nums1, nums2));

        int[] nums3 = { 10, 10 };
        int[] nums4 = { 20, 20 };
        System.out.println(minCost(nums3, nums4));

        int[] nums5 = { 10, 20 };
        int[] nums6 = { 30, 40 };
        System.out.println(minCost(nums5, nums6));

    }
}
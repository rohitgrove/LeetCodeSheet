import java.util.HashMap;

public class SubarraySumEqualsK {
    public static int bruteForce(int nums[], int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            for (int end = start; end < nums.length; end++) {
                int sum = 0;
                for (int i = start; i <= end; i++) {
                    sum += nums[i];
                }

                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }

    public static int optimizedApproach(int nums[], int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end < nums.length; end++) {
                sum += nums[end];

                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }

    public static int optimizedApproachWithMap(int nums[], int k) {
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum == k) {
                count++;
            }

            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static int subarraySum(int[] nums, int k) {
        return optimizedApproachWithMap(nums, k);
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 1, 1 };
        System.out.println(subarraySum(nums1, 2));
        int nums2[] = { 1, 2, 3 };
        System.out.println(subarraySum(nums2, 3));
    }
}

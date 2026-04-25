import java.util.HashMap;
public class LongestSubarrayWithGivenSumK {
    public static int bruteForce(int nums[], int k) {
        int count = 0;
        for (int startIndex = 0; startIndex < nums.length; startIndex++) {
            for (int endIndex = startIndex; endIndex < nums.length; endIndex++) {
                int sum = 0;

                for (int i = startIndex; i <= endIndex; i++) {
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
        for (int startIndex = 0; startIndex < nums.length; startIndex++) {
            int sum = 0;
            for (int endIndex = startIndex; endIndex < nums.length; endIndex++) {
                sum += nums[endIndex];

                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }

    public static int optimizedApproachWithMap(int nums[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;

        int count = 0;

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

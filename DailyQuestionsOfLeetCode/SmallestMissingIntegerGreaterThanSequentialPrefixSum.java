import java.util.HashSet;
import java.util.Set;

public class SmallestMissingIntegerGreaterThanSequentialPrefixSum {
    public static int bruteForce(int nums[]) {
        int seqSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                seqSum += nums[i];
            } else {
                break;
            }
        }

        while (true) {
            boolean found = false;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == seqSum) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                return seqSum;
            }
            seqSum++;
        }
    }

    public static int optimizedApproach(int[] nums) {
        // Intuition: same as before, but use a set for O(1) lookups
        int sum = nums[0];
        int i = 1;
        while (i < nums.length && nums[i] == nums[i - 1] + 1) {
            sum += nums[i];
            i++;
        }

        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            seen.add(num);
        }

        int candidate = sum;
        while (seen.contains(candidate)) {
            candidate++;
        }
        return candidate;
    }

    public static int missingInteger(int[] nums) {
        return optimizedApproach(nums);
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 2, 3, 2, 5 };
        System.out.println(missingInteger(nums1));
        int nums2[] = { 3, 4, 5, 1, 12, 14, 13 };
        System.out.println(missingInteger(nums2));
    }
}

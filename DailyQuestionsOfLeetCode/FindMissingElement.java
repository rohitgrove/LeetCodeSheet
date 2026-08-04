import java.util.ArrayList;
import java.util.List;

public class FindMissingElement {
    public static List<Integer> bruteForce(int nums[]) {
        int maxElement = Integer.MIN_VALUE;
        int minElement = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            maxElement = Math.max(maxElement, nums[i]);
            minElement = Math.min(minElement, nums[i]);
        }

        List<Integer> missingElements = new ArrayList<>();
        int findElement = minElement;
        for (int i = minElement; i <= maxElement; i++) {
            boolean flag = true;
            for (int j = 0; j < nums.length; j++) {
                if (findElement == nums[j]) {
                    flag = false;
                }
            }
            if (flag) {
                missingElements.add(findElement);
            }
            findElement++;
        }

        return missingElements;
    }

    public static List<Integer> optimizedApproach(int nums[]) {
        int hash[] = new int[101];

        for (int i = 0; i < nums.length; i++) {
            hash[nums[i]]++;
        }

        int firstElement = 0;
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] != 0) {
                firstElement = i;
                break;
            }
        }

        int lastElement = 0;
        for (int i = hash.length - 1; i >= 0; i--) {
            if (hash[i] != 0) {
                lastElement = i;
                break;
            }
        }

        List<Integer> missingElements = new ArrayList<>();
        for (int i = firstElement; i <= lastElement; i++) {
            if (hash[i] == 0) {
                missingElements.add(i);
            }
        }

        return missingElements;
    }

    public static List<Integer> findMissingElements(int[] nums) {
        return optimizedApproach(nums);
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 4, 2, 5 };
        System.out.println(findMissingElements(nums1));
        int nums2[] = { 7, 8, 6, 9 };
        System.out.println(findMissingElements(nums2));
        int nums3[] = { 5, 1 };
        System.out.println(findMissingElements(nums3));
    }
}

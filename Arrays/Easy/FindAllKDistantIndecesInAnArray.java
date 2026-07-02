import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class FindAllKDistantIndecesInAnArray {
    public static List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> indexOfKey = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                indexOfKey.add(i);
            }
        }

        Set<Integer> answers = new TreeSet<>();
        System.out.println(indexOfKey);

        for (int i = 0; i < indexOfKey.size(); i++) {
            int index = indexOfKey.get(i);
            int leftDiff = index - k;
            int rightDiff = index + k;
            int n = rightDiff < nums.length ? rightDiff : nums.length - 1;
            for (int j = leftDiff >= 0 ? leftDiff : 0; j <= n; j++) {
                answers.add(j);
            }
        }

        List<Integer> ans = new ArrayList<>(answers);
        return ans;
    }

    public static List<Integer> findKDistantIndicesOptimize(int[] nums, int key, int k) {
        List<Integer> keyIndices = new ArrayList<>();

        // Store all indices where nums[i] == key
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                keyIndices.add(i);
            }
        }

        List<Integer> ans = new ArrayList<>();

        int p = 0;

        for (int i = 0; i < nums.length; i++) {
            // Move pointer to the closer key index
            while (p + 1 < keyIndices.size() &&
                    Math.abs(i - keyIndices.get(p + 1)) <= Math.abs(i - keyIndices.get(p))) {
                p++;
            }

            if (Math.abs(i - keyIndices.get(p)) <= k) {
                ans.add(i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int nums1[] = { 3, 4, 9, 1, 3, 9, 5 };
        System.out.println(findKDistantIndices(nums1, 9, 1));
        // findKDistantIndices(nums1, 9, 1);
        int nums2[] = { 2, 2, 2, 2, 2 };
        System.out.println(findKDistantIndices(nums2, 2, 2));
        int nums3[] = { 222, 151, 842, 244, 103, 736, 219, 432, 565, 216, 36, 198, 10, 367, 778, 111, 307, 460, 92, 622,
                750, 36, 559, 983, 782, 432, 312, 111, 676, 179, 44, 86, 766, 371, 746, 905, 850, 170, 892, 80, 449,
                932, 295, 875, 259, 556, 730, 441, 153, 869 };
        System.out.println(findKDistantIndices(nums3, 153, 19));
    }
}

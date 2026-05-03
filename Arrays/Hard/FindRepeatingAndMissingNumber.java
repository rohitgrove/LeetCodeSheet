import java.util.ArrayList;

public class FindRepeatingAndMissingNumber {
    public static ArrayList<Integer> bruteForce(int nums[]) {
        int missing = -1;
        int repeating = -1;

        for (int i = 1; i <= nums.length; i++) {
            int cnt = 0;

            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == i) {
                    cnt++;
                }
            }

            if (cnt == 2) {
                repeating = i;
            } else if (cnt == 0) {
                missing = i;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(repeating);
        ans.add(missing);
        return ans;
    }

    public static ArrayList<Integer> betterAproach(int nums[]) {
        int missing = -1;
        int repeating = -1;

        int hash[] = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            hash[nums[i]]++;
        }

        for (int i = 1; i < hash.length; i++) {
            if (hash[i] == 2) {
                repeating = i;
            } else if (hash[i] == 0) {
                missing = i;
            }

            if (repeating != -1 && missing != -1) {
                break;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(repeating);
        ans.add(missing);
        return ans;
    }

    public static ArrayList<Integer> optimizedApproach(int nums[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        int repeating = -1;
        int missing = -1;

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] *= -1;
            } else {
                repeating = Math.abs(nums[i]);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                missing = i + 1;
                break;
            }
        }

        ans.add(repeating);
        ans.add(missing);

        return ans;
    }

    public static ArrayList<Integer> findTwoElement(int nums[]) {
        return optimizedApproach(nums);
    }

    public static void main(String[] args) {
        int nums1[] = { 3, 5, 4, 1, 1 };
        System.out.println(findTwoElement(nums1));
        int nums2[] = { 1, 2, 3, 6, 7, 5, 7 };
        System.out.println(findTwoElement(nums2));
        int nums3[] = { 4, 3, 6, 2, 1, 1 };
        System.out.println(findTwoElement(nums3));
    }
}

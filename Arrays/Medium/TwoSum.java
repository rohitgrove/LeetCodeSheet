import java.util.Arrays;
import java.util.HashMap;

class Pair {
    public int elemenent;
    public int index;

    public Pair(int elemenet, int index) {
        this.elemenent = elemenet;
        this.index = index;
    }
}

public class TwoSum {
    public static int[] bruteForce(int nums[], int target) {
        Pair pairArr[] = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            pairArr[i] = new Pair(nums[i], i);
        }

        Arrays.sort(pairArr, (a, b) -> a.elemenent - b.elemenent);
        int s = 0;
        int e = pairArr.length - 1;
        while (s < e) {
            if (pairArr[s].elemenent + pairArr[e].elemenent == target) {
                return new int[] { pairArr[s].index, pairArr[e].index };
            }

            if (pairArr[s].elemenent + pairArr[e].elemenent < target) {
                s++;
            } else if (pairArr[s].elemenent + pairArr[e].elemenent > target) {
                e--;
            }
        }

        return new int[] { -1, -1 };
    }

    public static int[] twoSum(int[] nums, int target) {
        return optimizedApproach(nums, target);
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

    public static void printAns(int nums[]) {
        System.out.println(nums[0] + " " + nums[1]);
    }

    public static void main(String[] args) {
        int nums1[] = { 2, 7, 11, 15 };
        printAns(twoSum(nums1, 9));
        int nums2[] = { 3, 2, 4 };
        printAns(twoSum(nums2, 6));
        int nums3[] = { 3, 3 };
        printAns(twoSum(nums3, 6));
    }
}

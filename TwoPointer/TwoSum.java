import java.util.Arrays;
import java.util.HashMap;

class Pair {
    public int element;
    public int index;

    public Pair(int element, int index) {
        this.element = element;
        this.index = index;
    }
}

public class TwoSum {
    public static int[] twoSumSol1(int[] nums, int target) {
        Pair temp[] = new Pair[nums.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = new Pair(nums[i], i);
        }

        Arrays.sort(temp, (a, b) -> a.element - b.element);

        int s = 0;
        int e = nums.length - 1;
        while (s < e) {
            int sum = temp[s].element + temp[e].element;
            if (sum == target) {
                return new int[] { temp[s].index, temp[e].index };
            } else if (sum < target) {
                s++;
            } else {
                e--;
            }
        }

        return new int[] { -1, -1 };
    }

    public static int[] twoSumSol2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] { map.get(target - nums[i]), i };
            }
            map.put(nums[i], i);
        }

        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int nums[] = { 2, 7, 11, 15 }, target = 9;
        int ans[] = twoSumSol2(nums, target);
        System.out.println(Arrays.toString(ans));
    }
}

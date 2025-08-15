import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllDuplicates {
    public static List<Integer> withoutMap(int nums[]) {
        List<Integer> ans = new ArrayList<>();

        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            largest = Math.max(largest, nums[i]);
        }

        int count[] = new int[largest + 1];

        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] > 1) {
                ans.add(i);
            }
        }

        return ans;
    }

    public static List<Integer> withMap(int nums[]) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (countMap.containsKey(nums[i])) {
                countMap.put(nums[i], countMap.get(nums[i]) + 1);
            } else {
                countMap.put(nums[i], 1);
            }
        }

        for (int key : countMap.keySet()) {
            if (countMap.get(key) > 1) {
                ans.add(key);
            }
        }

        return ans;
    }

    public static List<Integer> findDuplicates(int[] nums) {
        return withMap(nums);
    }

    public static void main(String[] args) {
        int nums[] = { 4, 3, 2, 7, 8, 2, 3, 1 };
        System.out.println(findDuplicates(nums));
    }
}

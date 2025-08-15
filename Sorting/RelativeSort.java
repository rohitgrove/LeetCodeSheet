import java.util.Arrays;
import java.util.HashMap;

public class RelativeSort {
    public static int[] optimizedApproach(int[] arr1, int[] arr2) {
        int length = 0;
        for (int i = 0; i < arr1.length; i++) {
            length = Math.max(length, arr1[i]);
        }

        int count[] = new int[length + 1];
        for (int i = 0; i < arr1.length; i++) {
            count[arr1[i]]++;
        }

        int ans[] = new int[arr1.length];
        int index = 0;
        for (int i = 0; i < arr2.length; i++) {
            if (count[arr2[i]] > 0) {
                ans[index] = arr2[i];
                index++;
                count[arr2[i]]--;
            }
        }

        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                ans[index] = i;
                index++;
                count[i]--;
            }
        }

        return ans;
    }

    public static int[] bruteForce(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            int num = arr2[i];
            int countNum = 0;
            for (int j = 0; j < arr1.length; j++) {
                if (num == arr1[j]) {
                    countNum++;
                }
            }

            count.put(num, countNum);
        }

        int res[] = new int[arr1.length];
        int idx = 0;
        for (int i = 0; i < arr2.length; i++) {
            int num = arr2[i];
            int countNum = count.get(num);
            while (countNum > 0) {
                res[idx++] = num;
                countNum--;
            }
            count.put(num, 0);
        }

        int temp = idx;
        for (int i = 0; i < res.length; i++) {
            int num = arr1[i];
            if (!count.containsKey(num)) {
                res[temp] = num;
                temp++;
            }
        }

        Arrays.sort(res, idx, res.length);

        return res;
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        return optimizedApproach(arr1, arr2);
    }

    public static void printArr(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr1[] = { 2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19 }, arr2[] = { 2, 1, 4, 3, 9, 6 };
        printArr(relativeSortArray(arr1, arr2));
        int arr3[] = { 28, 6, 22, 8, 44, 17 }, arr4[] = { 22, 28, 8, 6 };
        printArr(relativeSortArray(arr3, arr4));
    }
}

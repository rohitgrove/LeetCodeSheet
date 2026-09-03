import java.util.HashMap;

public class LargestSubArrayWith0Sum {
    public static int bruteForce(int arr[]) {
        int MaxLen = 0;
        for (int start = 0; start < arr.length; start++) {
            for (int end = start; end < arr.length; end++) {
                int sum = 0;
                for (int i = start; i <= end; i++) {
                    sum += arr[i];
                }

                if (sum == 0) {
                    MaxLen = Math.max(MaxLen, end - start + 1);
                }
            }
        }

        return MaxLen;
    }

    public static int betterApproach(int arr[]) {
        int MaxLen = 0;
        for (int start = 0; start < arr.length; start++) {
            int sum = 0;
            for (int end = start; end < arr.length; end++) {
                sum += arr[end];

                if (sum == 0) {
                    MaxLen = Math.max(MaxLen, end - start + 1);
                }
            }
        }

        return MaxLen;
    }

    public static int optimizedApproach(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxlen = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == 0) {
                maxlen = Math.max(maxlen, i + 1);
            } else if (!map.containsKey(sum)) {
                map.put(sum, i);
            } else {
                maxlen = Math.max(maxlen, i - map.get(sum));
            }
        }

        return maxlen;
    }

    public static int maxLength(int arr[]) {
        return optimizedApproach(arr);
    }

    public static void main(String[] args) {
        int arr1[] = { 15, -2, 2, -8, 1, 7, 10, 23 };
        System.out.println(maxLength(arr1));
        int arr2[] = { 2, 10, 4 };
        System.out.println(maxLength(arr2));
        int arr3[] = { 1, 0, -4, 3, 1, 0 };
        System.out.println(maxLength(arr3));
    }
}

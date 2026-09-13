import java.util.Arrays;

public class CountShadowPairs2 {
    static final long INF = Long.MAX_VALUE / 4;
    static final long NEG_INF = Long.MIN_VALUE / 4;

    static long[] max;
    static long[] secondMax;
    static int[] countMax;

    public static int shadowPairs(int[] nums) {
        int n = nums.length;

        long[] keys = new long[n];

        for (int i = 0; i < n; i++) {
            keys[i] = ((long) nums[i] << 32) | (i & 0xffffffffL);
        }

        Arrays.sort(keys);

        int[] position = new int[n];

        for (int i = 0; i < n; i++) {
            int originalIndex = (int) keys[i];
            position[originalIndex] = i;
        }

        max = new long[4 * n];
        secondMax = new long[4 * n];
        countMax = new int[4 * n];

        build(1, 0, n - 1);

        long answer = 0;

        for (int j = 0; j < n; j++) {

            int x = nums[j];

            long target = (long) x << 32;

            int right = lowerBound(keys, target);

            if (right > 0) {
                answer += updateAndCount(1, 0, n - 1, 0, right - 1, x);
            }

            activate(1, 0, n - 1, position[j]);
        }

        return (int) answer;
    }

    public static void build(int node, int left, int right) {
        if (left == right) {
            max[node] = NEG_INF;
            secondMax[node] = NEG_INF;
            countMax[node] = 1;

            return;
        }

        int mid = left + (right - left) / 2;

        build(node * 2, left, mid);
        build(node * 2 + 1, mid + 1, right);

        pull(node);
    }

    public static void pull(int node) {
        int leftChild = node * 2;
        int rightChild = node * 2 + 1;

        long a = max[leftChild];
        long b = max[rightChild];

        if (a > b) {
            max[node] = a;
            countMax[node] = countMax[leftChild];

            secondMax[node] = Math.max(secondMax[leftChild], b);

        } else if (b > a) {
            max[node] = b;
            countMax[node] = countMax[rightChild];

            secondMax[node] = Math.max(a, secondMax[rightChild]);

        } else {
            max[node] = a;
            countMax[node] = countMax[leftChild] + countMax[rightChild];
            secondMax[node] = Math.max(secondMax[leftChild], secondMax[rightChild]);
        }
    }

    public static void applyChmin(int node, long value) {
        if (max[node] > value) {
            max[node] = value;
        }
    }

    public static void push(int node) {
        applyChmin(node * 2, max[node]);
        applyChmin(node * 2 + 1, max[node]);
    }

    public static int updateAndCount(int node, int left, int right, int queryLeft, int queryRight, long x) {
        if (right < queryLeft || left > queryRight) {
            return 0;
        }
        if (max[node] < x) {
            return 0;
        }

        if (queryLeft <= left && right <= queryRight && (max[node] == x || secondMax[node] < x)) {
            int result = countMax[node];

            if (max[node] > x) {
                max[node] = x;
            }

            return result;
        }

        if (left == right) {
            int result = (max[node] >= x) ? 1 : 0;
            max[node] = Math.min(max[node], x);
            return result;
        }

        push(node);

        int mid = left + (right - left) / 2;

        int result = updateAndCount(node * 2, left, mid, queryLeft, queryRight, x)
                + updateAndCount(node * 2 + 1, mid + 1, right, queryLeft, queryRight, x);
        pull(node);

        return result;
    }

    public static void activate(int node, int left, int right, int position) {

        if (left == right) {

            max[node] = INF;
            secondMax[node] = NEG_INF;
            countMax[node] = 1;

            return;
        }
        push(node);

        int mid = left + (right - left) / 2;

        if (position <= mid) {
            activate(node * 2, left, mid, position);
        } else {
            activate(node * 2 + 1, mid + 1, right, position);
        }

        pull(node);
    }

    public static int lowerBound(long[] arr, long target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int nums1[] = { 3, 1, 4, 2, 5 };
        System.out.println(shadowPairs(nums1));
        int nums2[] = { 6, 7, 8, 9 };
        System.out.println(shadowPairs(nums2));
        int nums3[] = { 1, 4, 4 };
        System.out.println(shadowPairs(nums3));
    }
}

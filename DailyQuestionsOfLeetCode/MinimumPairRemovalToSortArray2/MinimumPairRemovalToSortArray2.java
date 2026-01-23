import java.util.HashMap;
import java.util.PriorityQueue;

public class MinimumPairRemovalToSortArray2 {
    public static int minimumPairRemoval(int[] nums) {
        HashMap<Integer, Integer> next = new HashMap<>();
        HashMap<Integer, Integer> last = new HashMap<>();
        HashMap<Integer, Boolean> active = new HashMap<>();
        HashMap<Integer, Integer> latest = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            if (a.sum != b.sum) {
                return Long.compare(a.sum, b.sum);
            } else {
                return a.current - b.current;
            }
        });
        int n = nums.length;
        long[] arr = new long[n];

        int breaks = 0;
        int ops = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = (long) nums[i];
            next.put(i, i + 1);
            last.put(i, i - 1);
            active.put(i, true);

            if (i != n - 1) {
                latest.put(i, count);
                pq.offer(new Node((long) nums[i] + nums[i + 1], i, count++));
                if (nums[i] > nums[i + 1]) {
                    breaks++;
                }
            }
        }

        while (breaks != 0) {
            while (!pq.isEmpty()
                    && (!active.get(pq.peek().current) || (latest.get(pq.peek().current) > pq.peek().id))) {
                pq.poll();
            }

            Node node = pq.poll();
            long sum = node.sum;
            int current = node.current;

            int la = last.get(current);
            int ne = next.get(current);
            int nene = next.get(ne);

            if (arr[current] > arr[ne]) {
                breaks--;
            }
            if (la != -1 && arr[la] > arr[current]) {
                breaks--;
            }
            if (nene != n && arr[ne] > arr[nene]) {
                breaks--;
            }

            arr[current] = sum;
            active.put(ne, false);
            next.put(current, nene);
            if (nene != n)
                last.put(nene, current);

            if (nene != n) {
                latest.put(current, count);
                pq.offer(new Node(sum + arr[nene], current, count++));
                if (arr[current] > arr[nene]) {
                    breaks++;
                }
            }
            if (la != -1) {
                latest.put(la, count);
                pq.offer(new Node(arr[la] + sum, la, count++));
                if (arr[la] > arr[current]) {
                    breaks++;
                }
            }

            ops++;
        }
        return ops;
    }

    public static void main(String[] args) {
        int nums1[] = { 5, 2, 3, 1 };
        System.out.println(minimumPairRemoval(nums1));
        int nums2[] = { 1, 2, 2 };
        System.out.println(minimumPairRemoval(nums2));
    }
}
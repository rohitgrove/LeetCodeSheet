import java.util.TreeSet;

public class DivideAnArrayIntoSubarraysWithMinimumCost2 {
    public static long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;
        TreeSet<Integer> sel = new TreeSet<>((a, b) -> {
            if(nums[a] == nums[b]) return a-b;
            return nums[a] - nums[b];
        });
        TreeSet<Integer> rem = new TreeSet<>((a, b) -> {
            if(nums[a] == nums[b]) return a-b;
            return nums[a] - nums[b];
        });

        k = k - 1;

        long currSum = 0;
        long ans;
        int last = Math.min(dist+1, n-1);
        for (int i = 1; i <= last; i++) {
            currSum += nums[i];
            sel.add(i);
        }

        while (sel.size() > k) {
            int idx = sel.pollLast();
            currSum -= nums[idx];
            rem.add(idx);
        }

        ans = currSum;

        for (int r = dist + 2, l= 1; r < n; r++, l++) {
            rem.add(r);

            if (sel.contains(l)) {
                sel.remove(l);
                currSum -= nums[l];

                int smallest = rem.pollFirst();
                sel.add(smallest);
                currSum += nums[smallest];
            } else {
                rem.remove(l);

                if (!sel.isEmpty() && !rem.isEmpty()
                        && nums[sel.last()] > nums[rem.first()]) {

                    int big = sel.pollLast();
                    currSum -= nums[big];
                    rem.add(big);

                    int small = rem.pollFirst();
                    sel.add(small);
                    currSum += nums[small];
                }
            }

            ans = Math.min(ans, currSum);
        }

        return nums[0] + ans;
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 3, 2, 6, 4, 2 };
        System.out.println(minimumCost(nums1, 3, 3));
        int nums2[] = { 10, 1, 2, 2, 2, 1 };
        System.out.println(minimumCost(nums2, 4, 3));
        int nums3[] = { 10, 8, 18, 9 };
        System.out.println(minimumCost(nums3, 3, 1));
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MinimumOperationsToMakeEveryElementPalindromicRightVersion {
    static final int[] EVEN;
    static final int[] ODD;

    static {
        ArrayList<Integer> all = new ArrayList<>(200000);
        for (int i = 1; i <= 9; i++) {
            all.add(i);
        }

        for (int i = 1; i < 100000; i++) {
            String s = Integer.toString(i);
            String rev = new StringBuilder(s).reverse().toString();

            if (s.length() <= 5) {
                long even = Long.parseLong(s + rev);
                if (even <= 1_999_999_999L) {
                    all.add((int) even);
                }
            }
            String rev2 = new StringBuilder(s.substring(0, s.length() - 1)).reverse().toString();
            long odd = Long.parseLong(s + rev2);
            if (odd <= 1_999_999_999L) {
                all.add((int) odd);
            }
        }

        Collections.sort(all);
        ArrayList<Integer> evenList = new ArrayList<>();
        ArrayList<Integer> oddList = new ArrayList<>();
        int prev = -1;
        for (int p : all) {
            if (p == prev || p <= 0) {
                continue;
            }
            prev = p;
            if ((p & 1) == 0) {
                evenList.add(p);
            } else {
                oddList.add(p);
            }
        }
        EVEN = evenList.stream().mapToInt(Integer::intValue).toArray();
        ODD = oddList.stream().mapToInt(Integer::intValue).toArray();
    }

    public static long minOperations(int[] nums) {
        long total = 0L;
        for (int x : nums) {
            int[] arr = ((x & 1) == 0) ? EVEN : ODD;
            int pos = Arrays.binarySearch(arr, x);
            if (pos >= 0) {
                continue; // already palindrome
            }

            int ins = -pos - 1;
            long best = Long.MAX_VALUE;
            if (ins < arr.length) {
                best = Math.min(best, Math.abs((long) arr[ins] - x));
            }
            if (ins - 1 >= 0) {
                best = Math.min(best, Math.abs((long) arr[ins - 1] - x));
            }

            total += best / 2; // +/-2 per operation
        }
        return total;
    }

    public static void main(String[] args) {
        int nums1[] = { 10, 12, 14, 16 };
        System.out.println(minOperations(nums1));
        int nums2[] = { 9, 10, 11, 10 };
        System.out.println(minOperations(nums2));
        int nums3[] = { 125 };
        System.out.println(minOperations(nums3));
    }
}
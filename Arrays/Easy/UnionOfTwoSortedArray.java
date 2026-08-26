import java.util.ArrayList;

public class UnionOfTwoSortedArray {
    public static ArrayList<Integer> findUnion(int nums1[], int nums2[]) {
        ArrayList<Integer> ans = new ArrayList<>();

        int idx1 = 0;
        int idx2 = 0;

        while (idx1 < nums1.length && idx2 < nums2.length) {
            if (nums1[idx1] < nums2[idx2]) {
                if (ans.isEmpty()) {
                    ans.add(nums1[idx1]);
                } else if (nums1[idx1] != ans.getLast()) {
                    ans.add(nums1[idx1]);
                }
                idx1++;
            } else if (nums1[idx1] == nums2[idx2]) {
                if (ans.isEmpty()) {
                    ans.add(nums1[idx1]);
                } else if (nums1[idx1] != ans.getLast()) {
                    ans.add(nums1[idx1]);
                }
                idx1++;
                idx2++;
            } else if (nums1[idx1] > nums2[idx2]) {
                if (ans.isEmpty()) {
                    ans.add(nums2[idx2]);
                } else if (nums2[idx2] != ans.getLast()) {
                    ans.add(nums2[idx2]);
                }
                idx2++;
            }
        }

        while (idx1 < nums1.length) {
            if (nums1[idx1] != ans.getLast()) {
                ans.add(nums1[idx1]);
            }
            idx1++;
        }

        while (idx2 < nums2.length) {
            if (nums2[idx2] != ans.getLast()) {
                ans.add(nums2[idx2]);
            }
            idx2++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 2, 3, 4, 5 }, nums2[] = { 1, 2, 3, 6, 7 };
        System.out.println(findUnion(nums1, nums2));
        int nums3[] = { 2, 2, 3, 4, 5 }, nums4[] = { 1, 1, 2, 3, 4 };
        System.out.println(findUnion(nums3, nums4));
    }
}

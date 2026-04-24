import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class UnionOfTwoSortedArray {
    public static ArrayList<Integer> bruteForce(int a[], int b[]) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < a.length; i++) {
            set.add(a[i]);
        }

        for (int i = 0; i < b.length; i++) {
            set.add(b[i]);
        }

        ArrayList<Integer> ans = new ArrayList<>(set);
        Collections.sort(ans);
        return ans;
    }

    public static ArrayList<Integer> optimizedApproach(int a[], int b[]) {
        ArrayList<Integer> ans = new ArrayList<>();

        int idx1 = 0, idx2 = 0;

        while (idx1 < a.length && idx2 < b.length) {
            if (a[idx1] < b[idx2]) {
                if (ans.isEmpty()) {
                    ans.add(a[idx1]);
                } else if (a[idx1] != ans.getLast()) {
                    ans.add(a[idx1]);
                }
                idx1++;
            } else if (a[idx1] == b[idx2]) {
                if (ans.isEmpty()) {
                    ans.add(a[idx1]);
                } else if (a[idx1] != ans.getLast()) {
                    ans.add(a[idx1]);
                }
                idx1++;
                idx2++;
            } else if (a[idx1] > b[idx2]) {
                if (ans.isEmpty()) {
                    ans.add(b[idx2]);
                } else if (b[idx2] != ans.getLast()) {
                    ans.add(b[idx2]);
                }
                idx2++;
            }
        }

        while (idx1 < a.length) {
            if (a[idx1] != ans.getLast()) {
                ans.add(a[idx1]);
            }
            idx1++;
        }

        while (idx2 < b.length) {
            if (b[idx2] != ans.getLast()) {
                ans.add(b[idx2]);
            }
            idx2++;
        }

        return ans;
    }

    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        return optimizedApproach(a, b);
    }

    public static void main(String[] args) {
        int a1[] = { 1, 2, 3, 4, 5 }, b2[] = { 1, 2, 3, 6, 7 };
        System.out.println(findUnion(a1, b2));
        int a3[] = { 2, 2, 3, 4, 5 }, b4[] = { 1, 1, 2, 3, 4 };
        System.out.println(findUnion(a3, b4));
        int a5[] = { 1, 1, 1, 1, 1 }, b6[] = { 2, 2, 2, 2, 2 };
        System.out.println(findUnion(a5, b6));
        int a7[] = { 4, 5, 8, 8, 8, 11, 14, 15, 17, 20 }, b8[] = { 1, 4, 4, 7 };
        System.out.println(findUnion(a7, b8));
    }
}

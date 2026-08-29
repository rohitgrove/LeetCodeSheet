import java.util.ArrayList;
import java.util.Collections;

public class ArrayLeaders {
    public static ArrayList<Integer> bruteForce(int arr[]) {
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int currEle = arr[i];
            boolean flag = true;
            for (int j = i + 1; j < arr.length; j++) {
                if (currEle < arr[j]) {
                    flag = false;
                }
            }

            if (flag) {
                ans.add(currEle);
            }
        }

        return ans;
    }

    public static ArrayList<Integer> optimized(int arr[]) {
        ArrayList<Integer> ans = new ArrayList<>();

        int max = arr[arr.length - 1];
        ans.add(max);
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] >= max) {
                max = arr[i];
                ans.add(max);
            }
        }

        Collections.reverse(ans);

        return ans;
    }

    public static ArrayList<Integer> leaders(int arr[]) {
        return optimized(arr);
    }

    public static void main(String[] args) {
        int arr1[] = { 16, 17, 4, 3, 5, 2 };
        System.out.println(leaders(arr1));
        int arr2[] = { 10, 4, 2, 4, 1 };
        System.out.println(leaders(arr2));
        int arr3[] = { 5, 10, 20, 40 };
        System.out.println(leaders(arr3));
    }
}

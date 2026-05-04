public class MergeTwo2dArraysBySummingValues {
    public static int[][] mergeArrays1(int[][] nums1, int[][] nums2) {
        int hash[] = new int[1001];
        for (int i = 0; i < nums1.length; i++) {
            hash[nums1[i][0]]++;
        }

        for (int i = 0; i < nums2.length; i++) {
            hash[nums2[i][0]]++;
        }

        int count = 0;
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] != 0) {
                count++;
            }
        }

        int res[][] = new int[count][2];

        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            int val1 = nums1[i][1];
            int val2 = nums2[j][1];
            int id1 = nums1[i][0];
            int id2 = nums2[j][0];

            if (id1 == id2) {
                res[k][0] = id1;
                res[k][1] = val1 + val2;
                i++;
                j++;
            } else {
                if (id1 < id2) {
                    res[k][0] = id1;
                    res[k][1] = val1;
                    i++;
                } else {
                    res[k][0] = id2;
                    res[k][1] = val2;
                    j++;
                }
            }
            k++;
        }

        while (i < nums1.length) {
            int val1 = nums1[i][1];
            int id1 = nums1[i][0];
            res[k][0] = id1;
            res[k][1] = val1;
            k++;
            i++;
        }
    
        while (j < nums2.length) {
            int val2 = nums2[j][1];
            int id2 = nums2[j][0];
            res[k][0] = id2;
            res[k][1] = val2;
            k++;
            j++;
        }

        return res;
    }

    public static int[][] mergeArrays2(int[][] nums1, int[][] nums2) {
        boolean hash[] = new boolean[1001];
        for (int i = 0; i < nums1.length; i++) {
            hash[nums1[i][0]] = true;
        }

        for (int i = 0; i < nums2.length; i++) {
            hash[nums2[i][0]] = true;
        }

        int count = 0;
        for (int i = 0; i < hash.length; i++) {
            if (hash[i]) {
                count++;
            }
        }

        int res[][] = new int[count][2];

        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            int val1 = nums1[i][1];
            int val2 = nums2[j][1];
            int id1 = nums1[i][0];
            int id2 = nums2[j][0];

            if (id1 == id2) {
                res[k][0] = id1;
                res[k][1] = val1 + val2;
                i++;
                j++;
            } else {
                if (id1 < id2) {
                    res[k][0] = id1;
                    res[k][1] = val1;
                    i++;
                } else {
                    res[k][0] = id2;
                    res[k][1] = val2;
                    j++;
                }
            }
            k++;
        }

        while (i < nums1.length) {
            int val1 = nums1[i][1];
            int id1 = nums1[i][0];
            res[k][0] = id1;
            res[k][1] = val1;
            k++;
            i++;
        }
    
        while (j < nums2.length) {
            int val2 = nums2[j][1];
            int id2 = nums2[j][0];
            res[k][0] = id2;
            res[k][1] = val2;
            k++;
            j++;
        }

        return res;
    }

    public static void printArr(int matrix[][]) {
        for (int[] row : matrix) {
            System.out.println(row[0] + " " + row[1]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums1[][] = { { 1, 2 },
                { 2, 3 },
                { 4, 5 } },
                nums2[][] = { { 1, 4 },
                        { 3, 2 },
                        { 4, 1 } };
        printArr(mergeArrays(nums1, nums2));

        int nums3[][] = { { 2, 4 },
                { 3, 6 },
                { 5, 5 } },
                nums4[][] = { { 1, 3 },
                        { 4, 3 } };
        printArr(mergeArrays(nums3, nums4));
    }
}

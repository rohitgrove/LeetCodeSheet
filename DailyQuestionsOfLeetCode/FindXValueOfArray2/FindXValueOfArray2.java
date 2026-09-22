public class FindXValueOfArray2 {
    public static int[] resultArray(int[] nums, int k, int[][] queries) {
        SegmentTree tree = new SegmentTree(nums, k);
        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            tree.update(index, value);

            Info result = tree.query(start, nums.length);
            answer[i] = result.ways[x];
        }

        return answer;
    }

    public static void printArr(int ans[]) {
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4, 5 }, k = 3, queries[][] = { { 2, 2, 0, 2 },
                { 3, 3, 3, 0 },
                { 0, 1, 0, 1 } };
        printArr(resultArray(nums, k, queries));
    }
}

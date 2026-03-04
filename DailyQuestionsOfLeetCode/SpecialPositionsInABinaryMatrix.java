public class SpecialPositionsInABinaryMatrix {
    public static int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[] row = new int[m];
        int[] col = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                row[i] += mat[i][j];
                col[j] += mat[i][j];
            }
        }

        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && row[i] == 1 && col[j] == 1) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int mat1[][] = { { 1, 0, 0 },
                { 0, 0, 1 },
                { 1, 0, 0 } };
        System.out.println(numSpecial(mat1));
        int mat2[][] = { { 1, 0, 0 },
                { 0, 1, 0 },
                { 0, 0, 1 } };
        System.out.println(numSpecial(mat2));
    }
}

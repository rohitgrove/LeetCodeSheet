import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public static void storeAnswer(char[][] board, List<List<String>> ans) {
        List<String> currAns = new ArrayList<>();
        for (char[] row : board) {
            currAns.add(String.valueOf(row));
        }
        ans.add(currAns);
    }

    public static boolean isSafe(char[][] board, int row, int col) {
        int r = row;
        int c = col;

        while (r < board.length) {
            if (board[r][c] == 'Q') {
                return false;
            }
            r++;
        }

        r = row;

        while (r < board.length && c >= 0) {
            if (board[r][c] == 'Q') {
                return false;
            }
            r++;
            c--;
        }

        r = row;
        c = col;
        while (c >= 0) {
            if (board[r][c] == 'Q') {
                return false;
            }
            c--;
        }

        r = row;
        c = col;

        while (r >= 0&& c >= 0) {
            if (board[r][c] == 'Q') {
                return false;
            }
            r--;
            c--;
        }

        return true;
    }

    public static void solve(int n, char[][] board, List<List<String>> ans, int col) {
        if (col >= board.length) {
            storeAnswer(board, ans);
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                solve(n, board, ans, col + 1);
                board[row][col] = '.';
            }
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        char board[][] = new char[n][n];
        for (char[] cs : board) {
            Arrays.fill(cs, '.');
        }

        List<List<String>> ans = new ArrayList<>();

        solve(n, board, ans, 0);

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
}

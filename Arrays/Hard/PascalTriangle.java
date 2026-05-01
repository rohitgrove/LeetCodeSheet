import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.get(0).add(1);
        if (numRows == 1) {
            return ans;
        }

        int row = 1;
        while (row < numRows) {
            int col = 0;
            List<Integer> currRow = new ArrayList<>();
            while (col <= row) {
                if (col == 0 || col == row) {
                    currRow.add(1);
                } else {
                    int firstEle = ans.get(row - 1).get(col - 1);
                    int secondEle = ans.get(row - 1).get(col);
                    currRow.add(firstEle + secondEle);
                }
                col++;
            }
            ans.add(currRow);
            row++;
        }

        return ans;
    }

    public static List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.get(0).add(1);
        if (numRows == 1) {
            return ans;
        }

        int row = 1;
        while (row < numRows) {
            int col = 0;
            List<Integer> currRow = new ArrayList<>();
            List<Integer> prevRow = ans.get(row - 1);
            while (col <= row) {
                if (col == 0 || col == row) {
                    currRow.add(1);
                } else {
                    int firstEle = prevRow.get(col - 1);
                    int secondEle = prevRow.get(col);
                    currRow.add(firstEle + secondEle);
                }
                col++;
            }
            ans.add(currRow);
            row++;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(generate1(5));
    }
}

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.get(0).add(1);
        if (numRows == 1) {
            return ans;
        }

        int row = 1;
        while (row < numRows) {
            int col = 0;
            List<Integer> currAns = new ArrayList<>();
            while (col <= row) {
                if (col == 0 || col == row) {
                    currAns.add(1);
                } else {
                    int firstEle = ans.get(row - 1).get(col - 1);
                    int secondEle = ans.get(row - 1).get(col);
                    currAns.add(firstEle + secondEle);
                }
                col++;
            }
            ans.add(currAns);
            row++;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}

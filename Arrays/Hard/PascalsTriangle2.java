import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle2 {
    public static List<Integer> getRow(int rowIndex) {
        int numRows = rowIndex + 1;
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.get(0).add(1);

        while (ans.size() < numRows) {
            List<Integer> currAns = new ArrayList<>();
            List<Integer> lastRow = ans.getLast();
            int size = lastRow.size();
            for (int i = 0; i <= size; i++) {
                if (i == 0 || i == size) {
                    currAns.add(1);
                } else {
                    int digit1 = lastRow.get(i - 1);
                    int digit2 = lastRow.get(i);
                    currAns.add(digit1 + digit2);
                }
            }

            ans.add(currAns);
        }

        return ans.get(rowIndex);
    }

    public static void main(String[] args) {
        System.out.println(getRow(3));
        System.out.println(getRow(0));
        System.out.println(getRow(1));
    }
}
